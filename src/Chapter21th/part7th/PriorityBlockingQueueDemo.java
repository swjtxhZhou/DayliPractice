package Chapter21th.part7th;
import static Utils.StringUtils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 这是一个很基础得优先级队列，它具有可阻塞得读取操作。下面是一个示例，其中得优先级队列得对象是按照优先级顺序从队列中出现得任务。PrioritedTask被赋予一个优先级数字，以此来提供这种顺序
 */
class PrioritizedTask implements Runnable,Comparable<PrioritizedTask>{
    private Random rand = new Random(47);
    private static int counter = 0;
    private final int id = counter++;
    private final int priority;
    protected static List<PrioritizedTask> sequence=new ArrayList<>();
    public PrioritizedTask(int priority){
        this.priority=priority;
        sequence.add(this);
    }
    public int compareTo(PrioritizedTask arg){
        return priority < arg.priority ? 1 : (priority > arg.priority ? -1 : 0);
    }
    public void run(){
        try{
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(250));
        }catch(InterruptedException e){

        }
        println(this.toString());
    }
    public String toString(){
        return String.format("priority[%1$-2d]",priority)+" Task "+id;
    }
    public String summary(){
        return "(id "+id+" : priority "+priority+")";
    }
    public static class EndSentinel extends PrioritizedTask{
        private ExecutorService exec;
        public EndSentinel(ExecutorService e){//Priority没有默认的构造器，必须按下面的顺序，先调用父类的构造器，在完成其他的任务。
            super(-1);
            exec=e;
        }
        public void run(){
            int count = 0;
            for(PrioritizedTask pt:sequence){
                println(pt.summary());
                if(++count % 5==0){
                    println(" ");
                }
            }
            println(" ");
            println(this+"Calling ShutdownNow()");
            exec.shutdownNow();
        }
    }
}
class PrioritizedTaskProducer implements Runnable{
    private Random rand= new Random(47);
    private Queue<Runnable> queue;
    private ExecutorService exec;
    public PrioritizedTaskProducer(Queue<Runnable> q,ExecutorService e){
        queue = q;
        exec = e;
    }
    public void run(){
        for(int i = 0;i<20;i++){
            queue.add(new PrioritizedTask(rand.nextInt(10)));
            Thread.yield();
        }
        try{
            for(int i=0;i<10;i++){
                TimeUnit.MILLISECONDS.sleep(250);
                queue.add(new PrioritizedTask(10));
            }
            for(int i=0;i<10;i++){
                queue.add(new PrioritizedTask(i));
            }
            queue.add(new PrioritizedTask.EndSentinel(exec));
        }catch(InterruptedException e){

        }
        println("Finished PrioritiedTaskProducer");
    }
}
class PrioritizedTaskConsumer implements Runnable{
    private PriorityBlockingQueue<Runnable> q;
    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> q){
        this.q=q;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                q.take().run();
            }
        }catch (InterruptedException e){

        }
        println("Finished PrioritizedTaskConsumer");
    }
}
public class PriorityBlockingQueueDemo {
    public static void main(String[] args)throws Exception{
        Random rand = new Random();
        ExecutorService exec = Executors.newCachedThreadPool();
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();
        /**
         * PrioritizedTaskProducer和PrioritizedTaskConsumer通过PrioritizedBlockingQueue彼此连接，因为这种队列得阻塞特性提供了所有必需得同步，所以这里不需要任何显式得同步
         */
        exec.execute(new PrioritizedTaskProducer(queue,exec));
        exec.execute(new PrioritizedTaskConsumer(queue));
    }
}
