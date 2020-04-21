package thinkingInJava.Chapter21th.part5;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static Utils.StringUtils.*;

class Blocker{
    /**
     *
     */
    synchronized void waitingCall(){
        try{
            while(!Thread.interrupted()){
                wait();
                println(Thread.currentThread()+" ");
            }
        }catch(InterruptedException e){
            //exit this way
        }
    }

    /**
     * 在技术上，可能会有多个·任务·在单个Car对象上处于wait（）状态·，因此调用notifyAll（）比只调用notify（）更安全。
     *
     * 使用notify而不是notifyAll（）是一种优化，如果你希望使用notify，就必须保证被唤醒的是恰当的任务。并且所有任务必须等待相同条件。当条件发生变化时，，只有一个任务可以从中受益。最后，这些限制对所有可能存在的子类都必须总是起作用的，若这些规则中有任何一条不能满足，那么就必须使用notifyAll（）而不是notify（）
     *
     * notifyAll（）因某个特定锁而被调用时，只有等待这个锁的任务才会被唤醒；
     */
    synchronized void prod(){notify();}
    synchronized void prodAll(){notifyAll();}
}
class Task implements Runnable{
    static Blocker blocker= new Blocker();
    public void run(){
        blocker.waitingCall();
    }
}
class Task2 implements Runnable{
    static Blocker blocker = new Blocker();
    public void run(){
        blocker.waitingCall();
    }
}
public class NotifyVSNotifyAll {
    public static void main(String[] args)throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            exec.execute(new Task());
        }
        exec.execute(new Task2());
        Timer timer = new Timer();
        /**
         * 设置为每0.4秒执行一次run方法 ，这个run（）方法交替地在Task。blocker上调用notify和notifyAll
         */
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;
            @Override
            public void run() {
                if(prod){
                    println("notify()");
                    Task.blocker.prod();
                    prod= false;
                }else{
                    println("notifyAll() ");
                    Task.blocker.prodAll();
                    prod=true;
                }
            }
        },400,400);
        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        println("timer canceled");
        TimeUnit.MILLISECONDS.sleep(500);
        println("Task2.blocker.prodAll()");
        /**
         * 只有对应对象的锁才能唤醒Task2对象
         */
        Task2.blocker.prodAll();
        TimeUnit.MILLISECONDS.sleep(500);
        println("Shutting down!");
        exec.shutdownNow();
    }
}
