package Chapter21th.part2.part5;
import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static Utils.StringUtils.*;
class Car{
    private boolean waxOn = false;
    public synchronized void waxed(){
        waxOn=true;
        notifyAll();
    }
    public synchronized void buffed(){
        waxOn = false;
        notifyAll();
    }
    public synchronized void waitForWaxing()throws InterruptedException{
        /**
         * 通过调用wait（）而被挂起。这个行为发生在synchronized方法中很重要
         * 在这样的方法中，任务已经获得了锁，当调用wait（）时，线程被挂起，而锁被释放，锁被释放这一点是本质所在。
         * 为了安全的改变对象的状态（例如将waxOn改变为true），其他某个任务就必须能够获得锁，从而将waxOn（）改变为true，之后waxed（）调用notifyAll（），这将唤醒对wait（）调用的中被挂起的任务。为了使该任务从wait（）中唤醒，他必须首先重新获得当他进入wait（）时释放的锁。在这个锁变得可用之前，这个任务是不会被唤醒的！
         */
        while(waxOn == false){
            wait();
        }
    }
    public synchronized void waitForBuffing()throws InterruptedException{
        /**
         * ！！！使用while（）循环包围wait（），的本质就是检查所感兴趣的特定条件，并在条件不满足的情况下返回到wait（）当中
         */
        while(waxOn == true){
            wait();
        }
    }
}
class WaxOn implements Runnable{
    private Car car;
    public WaxOn(Car car){
        this.car=car;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                println("Wax on!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();//涂蜡结束
                car.waitForBuffing();//等待抛光
            }
        }catch(InterruptedException e){
            println("Exiting via InterruptedException!");
        }
        println("Ending Wax On task!~");
    }
}

class WaxOff implements Runnable{
    private Car car;
    public WaxOff(Car car){
        this.car = car;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                car.waitForWaxing();
                println("wax off!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();//执行抛光
            }
        }catch(InterruptedException e){
            println("Exiting via InterruptedException");
        }
        println("Ending Wax off task!");
    }
}

public class WaxOMatic {
    public static void main(String[] args)throws Exception{
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
