package thinkingInJava.Chapter21th.part5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static Utils.StringUtils.*;
class Meal{
    private final int orderNum;
    public Meal(int orderNum){this.orderNum=orderNum;}
    public String toString(){
        return "Meal "+orderNum;
    }
}
class WaitPerson implements Runnable{
    private Restaurant restaurant;
    public WaitPerson(Restaurant r){
        restaurant = r;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                synchronized(this) {//服务员对象的同步锁
                    while (restaurant.meal == null) {//如果没有新点的菜单就一直等待
                        wait();
                    }
                }
                println("waitPerson got "+restaurant.meal);
                synchronized (restaurant.chef){//厨师对象的锁
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();//准备做另一份菜单
                }
            }
        }catch(InterruptedException e){
            println("WaitPerson interrupted");
        }
    }
}
class Chef implements Runnable{
    private Restaurant restaurant;
    private int count = 0;
    public Chef(Restaurant r){
        restaurant = r;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                synchronized(this){//获取厨师对象的同步锁
                    while(restaurant.meal !=null){//如果没有点餐，就一直处于等待状态
                        wait();
                    }
                }
                if(++count == 10){
                    println("Out Of food, closing");
                    restaurant.exec.shutdownNow();
                }
                println("Order up!");//点餐
                synchronized(restaurant.waitPerson){//获取服务员对象的同步锁
                    restaurant.meal = new Meal(count);//新建一个点餐单
                    restaurant.waitPerson.notifyAll();//通知到服务员对象中的同步wait（）方法，有新的菜单
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch(InterruptedException e){
            println("Chef interrupted");
        }
    }
}

/**
 * 服务员等待厨师准备好膳食，当厨师准备好，他会通知服务员，之后服务员上菜，然后继续等待
 * 厨师代表生产者而·服务员代表消费者。两个任务，必须在生产和消费之间进行握手，而系统必须以有序的方式关闭
 *
 * 这个示例中，对于一个任务而言，只有一个单一的地点用于存放对象，从而使得另一个任务稍后可以使用这个对象。但是在典型的生产者和消费者实现中，应使用先进先出队列来存储被生产和消费的对象。
 *
 */
public class Restaurant {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    Chef chef = new Chef(this);
    WaitPerson waitPerson = new WaitPerson(this);
    public Restaurant(){
        exec.execute(chef);
        exec.execute(waitPerson);
    }
    public static void main(String[] args){
        new Restaurant();
    }
}
