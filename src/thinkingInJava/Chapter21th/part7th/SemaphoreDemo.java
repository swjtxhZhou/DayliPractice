package thinkingInJava.Chapter21th.part7th;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static Utils.StringUtils.*;

class CheckoutTask<T> implements Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private Pool<T> pool;
    public CheckoutTask(Pool<T> pool){
        this.pool = pool;
    }
    public void run(){
        try{
            T item = pool.checkOut();//从对象池取出一个对象
            println(this+" checked out "+item);
            TimeUnit.SECONDS.sleep(1);
            println(this+" check in "+item);
            pool.checkIn(item);//归还对象
        }catch(InterruptedException e){

        }
    }
    public String toString(){
        return "CheckedoutTask "+id+" ";
    }
}
public class SemaphoreDemo {
    final static int SIZE = 25;
    public static void main(String[] args)throws Exception{
        final Pool<Fat> pool = new Pool<Fat>(Fat.class,SIZE);//创建一个Fat对象的池子，数量是25
        ExecutorService exec = Executors.newCachedThreadPool();
        /**
         * 一组checkoutTask开始操练这个pool
         */
        for(int i=0;i<SIZE;i++){
            exec.execute(new CheckoutTask<Fat>(pool));//这25个CheckoutTask能正常运行，计数信号量能够正常运行
        }
        println("All CheckoutTasks created");
        List<Fat> list = new ArrayList<>();
        /**
         * 在main（）线程中签出池中的Fat对象，但是并不签入他们
         */
        for(int i=0;i<SIZE;i++){
            Fat f = pool.checkOut();
            print(i+" :main()");
            f.operation();
            list.add(f);
        }
        /**
         *一旦池中所有对象都被签出，Semaphore将不再允许执行任何签出操作。blocked的run（）方法也会被阻塞
         */
        Future<?> blocked = exec.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    pool.checkOut();
                }catch (InterruptedException e){
                    println("checkout Interrupted");
                }
            }
        });
        TimeUnit.SECONDS.sleep(2);
        /**
         *
         */
        blocked.cancel(true);
        println("Checking in objects in "+list);
        for(Fat f:list){
            pool.checkIn(f);
        }
        /**
         *
         */
        for(Fat f:list){
            pool.checkIn(f);
        }
        /**
         * shutdown只是将线程池的状态设置为SHUTWDOWN状态，正在执行的任务会继续执行下去，没有被执行的则中断。而shutdownNow则是将线程池的状态设置为STOP，正在执行的任务则被停止，没被执行任务的则返回。
         */
        exec.shutdown();
    }
}
