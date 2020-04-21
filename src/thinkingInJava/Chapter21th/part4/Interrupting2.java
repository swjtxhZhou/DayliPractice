package thinkingInJava.Chapter21th.part4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static Utils.StringUtils.*;

class BlockedMutex{
    private Lock lock = new ReentrantLock();

    /**
     * BlockedMutex的构造器获取所创建对象上自身的Lock，并且从不释放这个锁
     * 出于这个原因，若你试图从第二个任务中调用f（）（不同于创建这个BlockedMutex的任务），那么总是因Mutex不可获得而被阻塞
     */
    public BlockedMutex(){
        lock.lock();
    }
    public void f(){
        try{
            lock.lockInterruptibly();
            println("lock acquired in f()");
        }catch (InterruptedException e){
            println("Interrupted from lock acquisition in f()");
        }
    }
}
class Blocked2 implements Runnable{
    BlockedMutex blocked = new BlockedMutex();
    public void run(){
        println("Waiting for f() in BlockedMutex");
        blocked.f();
        println("Broken out of blocked call");
    }
}
public class Interrupting2 {
    public static void main(String[] args)throws Exception{
        Thread t = new Thread(new Blocked2());
        t.start();
        /**
         * 在Blocked中，run（）方法总是在调用blocked.f()的地方停止
         * interrupt（）可以打断被互斥所阻塞调用
         */
        TimeUnit.SECONDS.sleep(2);
        println("Issuing t.interrupt()");
        t.interrupt();
    }
}
