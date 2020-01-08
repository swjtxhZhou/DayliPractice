package Chapter21th.part2.part5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static Utils.StringUtils.*;

class Car2{
    private Lock lock = new ReentrantLock();
    /**
     * 使用互斥并允许任务挂起的基本类事condition，可以通过在Condition上调用await（）来挂起一个任务。当外部条件发生变化，意味者某个任务应该继续执行时，可以通过调用signal（）来通知这个任务，从而唤醒目标任务，或者调用signalAll（）来唤醒所有在这个Condition上被其自身挂起的任务（与使用notifyAll（）相比，signalAll是跟安全的方式）
     *
     * Condition对象被用来管理任务间的通信，但是这个condition对象不包含任何有关处理状态的信息，因此需要额外的表示处理状态的信息，即WaxOn
     */
    private Condition condition = lock.newCondition();
    private boolean waxOn = false;
    public void waxed(){
        lock.lock();
        try{
            waxOn = true;
            condition.signalAll();
        }finally{
            lock.unlock();
        }
    }
    public void buffed(){
        lock.lock();
        try{
            waxOn = false;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void waitForWaxing()throws InterruptedException{
        lock.lock();
        /**
         * 每个对lock（）的调用都必须紧跟一个try-finally子句，用来保证在所有情况下都可以释放锁
         * 在使用内建版本时，任务在可以调用await（），signal（），siganlAll（）之前，必须拥有这个锁
         */
        try{
            while(waxOn == false){condition.await();}
        }finally {
            lock.unlock();
        }
    }
    public void waitForBuffing()throws InterruptedException{
        lock.lock();
        try{
            while(waxOn == true){
                condition.await();
            }
        }finally{
            lock.unlock();
        }
    }
}
class WaxOn2 implements Runnable{
    private  Car2 car;
    public WaxOn2(Car2 c){
        car = c;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                println("Wax ON!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        }catch(InterruptedException e){
            println("exiting via InterruptedException");
        }
        println("ending wax on task!");
    }
}
class WaxOff2 implements Runnable{
    private Car2 car;
    public WaxOff2(Car2 c){
        car = c;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                car.waitForWaxing();
                println("Wax off!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        }catch(InterruptedException e){
            println("Ending Wax off task!");
        }
    }
}
public class WaxOMatic2 {
    public static void main(String[] args)throws Exception{
        Car2 car = new Car2();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOn2(car));
        exec.execute(new WaxOff2(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
