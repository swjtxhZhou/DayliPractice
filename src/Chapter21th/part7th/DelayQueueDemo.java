package Chapter21th.part7th;
import static Utils.StringUtils.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * 其中Delayed对象自身就是任务，而DelayedTaskConsumer将最“紧急”的任务（到期时间最长的任务）从队列中取出，然后运行他。这样DelayedTaskConsumer就成为了优先级队列的一种变体
 */

/**
 * DelayedTask包含一个称为sequence的List《DelayedTask》，它保存了任务被创建的顺序
 */
class DelayedTask implements Runnable, Delayed{
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;
    protected static List<DelayedTask> sequence = new ArrayList<>();
    public DelayedTask(int delayInMillisecondes){
        delta = delayInMillisecondes;
        /**
         * delta的值是以毫秒为单位存储的，System。nanoTime（）产生的时间则是以纳秒为单位的。你可以转换delta的值，方法是声明它的单位以及你希望以什么单位来表示
         *
         * NANOSECONDS.convert(delta,MILLISECONDS);表示的是把delta（以毫秒为单位得数值）转换为（NANOSECONDS）以纳秒为单位
         */
        trigger = System.nanoTime()+NANOSECONDS.convert(delta,MILLISECONDS);
        sequence.add(this);
    }

    /**
     * Delayed接口的方法，他可以用来告知延迟到期有多长时间，或者延迟多长时间之前已经到期
     * 在getDelay中，希望使用的单位是作为unit参数传递进来的，你使用它将当前时间与触发时间之间的差转换为调用者要求的单位，而无需知道这些单位是什么。
     *
     *  延迟任务是否到时就是按照这个方法判断如果返回的是负数则说明到期否则还没到期
     * @param unit
     * @return
     */
    public long getDelay(TimeUnit unit){
        return unit.convert(trigger-System.nanoTime(),NANOSECONDS);
    }
    public int compareTo(Delayed arg){
        DelayedTask that = (DelayedTask)arg;
        if(trigger<that.trigger)return -1;
        if(trigger>that.trigger)return 1;
        return 0;
    }
    public void run(){
        println(this+" ");
    }
    public String toString(){
        return String.format("[%1$-4d]",delta)+" Task "+id;
    }
    public String summary(){
        return "("+id+":"+delta+")";
    }

    /**
     * 嵌套的EndSentinel类提供了一种关闭所有事务的途径，具体做法是将其放置为队列的最后一个元素
     */
    public static class EndSentinel extends DelayedTask{
        private ExecutorService exec;
        public EndSentinel(int delay,ExecutorService e){
            super(delay);
            exec= e;
        }
        public void run(){
            for(DelayedTask pt:sequence){
                println(pt.summary()+" ");
            }
            println(this+" Calling shtdownNow()");
            exec.shutdownNow();
        }
    }
}

/**
 *DelayedTaskConsumer其自身是一个任务，所以它有自己的Thread，它可以使用这个线程来运行从队列中获取的所有任务。由于任务是按照队列优先级的顺序执行的，因此不需要启动任何单独的线程来运行DelayedTask
 */
class DelayedTaskConsumer implements Runnable{
    private DelayQueue<DelayedTask> q;
    public DelayedTaskConsumer(DelayQueue<DelayedTask> q){
        this.q = q;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                q.take().run();
            }
        }catch (InterruptedException e){

        }
        println("Finished DelayedTaskConsumer!");
    }
}
public class DelayQueueDemo {
    public static void main(String[] args){
        Random rand= new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
        DelayQueue<DelayedTask> queue=new DelayQueue<>();
        for(int i= 0;i<20;i++){
            queue.put(new DelayedTask(rand.nextInt(5000)));
        }
        queue.add(new DelayedTask.EndSentinel(5000,exec));
        exec.execute(new DelayedTaskConsumer(queue));
    }
}
