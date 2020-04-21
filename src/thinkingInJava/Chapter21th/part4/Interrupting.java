package thinkingInJava.Chapter21th.part4;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import static Utils.StringUtils.*;

/**
 * 这个类是可中断的阻塞示例
 */
class SleepBlocked implements Runnable{
    public void run(){
        try{
            TimeUnit.SECONDS.sleep(100);
        }catch(InterruptedException e){
            System.out.println("InterruptedException!");
        }
        System.out.println("Exiting SleepBlocked.run()!");
    }
}

/**
 * 不可中断的阻塞示例
 * I/O的等待是不可中断的
 * 这意味者I/O具有锁住你的多线程程序的潜在可能，特别基于web的程序，更是关乎利害
 */
class IOBlocked implements Runnable{
    private InputStream in;
    public IOBlocked(InputStream is){
        in = is;
    }
    public void run(){
        try{
            System.out.println("waiting for read();");
            in.read();
        }catch (IOException e){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Interruped from blocked I/O");
            }else{
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting IOBlocked.run()!");
    }
}

/**
 * 不可中断阻塞示例
 * synchronized块上的等待是不可中断的
 */
class SynchronizedBlocked implements Runnable{
    public synchronized void f(){
        while(true){
            Thread.yield();
        }
    }

    /**
     * 为了演示SynchronizedBlock,我们必须首先获取锁。这是通过在构造器中创建匿名的Thread类的实例来实现的。
     * 这个匿名Thread类对象通过调用f（）获取对象的锁（这个线程必须有别于SynchronizedBlock驱动run（）的线程，因为一个线程可以多次获得某个对象的锁）
     * 由于f（）永远都不返回，因此这个锁永远都不会释放掉，而SynchronizedBlock。run（）在调用f（），并阻塞以等待这个锁被释放
     */
    public SynchronizedBlocked(){
        new Thread(){
            public void run(){
                System.out.println("Trying to call f()");
                f();
            }
        }.start();
    }
    public void run(){
        System.out.println("Trying to call f().");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}
public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();
    static void test(Runnable r)throws InterruptedException{
        /**
         * 有返回值的方式，可以选择某个进程单独取消，即使使用的是线程池
         */
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        println("Interrupting "+r.getClass().getName());
        f.cancel(true);
        println("Interrupted sent to "+r.getClass().getName());
    }
    public static void main(String[] args)throws Exception{
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        print("Aborting with System.exit(0)");
        System.exit(0);
    }
}
