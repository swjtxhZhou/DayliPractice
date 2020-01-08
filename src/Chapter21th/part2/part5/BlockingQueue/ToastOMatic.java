package Chapter21th.part2.part5.BlockingQueue;


import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import static Utils.StringUtils.*;

/**
 * 一台机器具有三个任务，一个制作吐司，一个给吐司抹黄油，一个涂果酱，可以通过各个处理过程之间的BlockingQueue来运行这个吐司制作过程
 *
 * 这个示例中没有任何显式的同步（使用lock或者synchronized关键字的同步），同步由队列（其内部是同步的）和系统的设计隐式的管理了==每片Toast在任何时刻都只由一个任务在操作。因为队列的阻塞，使得处理过程将被自动地挂起和恢复
 */

class Toast{
    /**
     * 使用枚举的优秀示例
     */
    public enum Status{DRY,BUTTERED,JAMMED}
    private Status status = Status.DRY;
    private final int id;
    public Toast(int idn){id = idn;}
    public void butter(){status = Status.BUTTERED;}
    public void jam(){status = Status.JAMMED;}
    public Status getStatus(){return status;}
    public int getId(){return id;}
    public String toString(){
        return "Toast "+id+": "+status;
    }
}
class ToastQueue extends LinkedBlockingQueue<Toast>{}
class Toaster implements Runnable{
    private ToastQueue toastQueue;
    private int count = 0;
    private Random random = new Random(47);
    public Toaster(ToastQueue tq){toastQueue = tq;}
    public void run(){
        try{
            while(!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(100+ random.nextInt(500));
                Toast t = new Toast(count++);
                println(t.toString());
                toastQueue.put(t);
            }
        }catch (InterruptedException e){
            println("Toast interrupted");
        }
        println("Toaster off");
    }
}
class Butterer implements Runnable{
    private ToastQueue dryQueue,butterQueue;
    public Butterer(ToastQueue dry,ToastQueue buttered){
        dryQueue = dry;
        butterQueue = buttered;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                Toast t = dryQueue.take();
                t.butter();
                println(t.toString());
                butterQueue.put(t);
            }
        }catch(InterruptedException e){
            println("Butterer interrupted");
        }
        println("Butterer off!");
    }
}
class Jammer implements Runnable{
    private ToastQueue butteredQueue,finishedQueue;
    public Jammer(ToastQueue buttered,ToastQueue finished){
        butteredQueue = buttered;
        finishedQueue = finished;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                Toast t = butteredQueue.take();
                t.jam();
                println(t.toString());
                finishedQueue.put(t);
            }
        }catch(InterruptedException e){
            println("Jammer interrupted");
        }
        println("Jammer off!");
    }
}
class Eater implements Runnable{
    private ToastQueue finishedQueue;
    private int counter = 0;
    public Eater(ToastQueue finished){
        finishedQueue = finished;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                Toast t = finishedQueue.take();
                if(t.getId()!=counter++ ||t.getStatus() !=Toast.Status.JAMMED){
                    println(">>>>> Error: "+t);
                    System.exit(1);
                }else{
                    println("Chomp! "+t);
                }
            }
        }catch(InterruptedException e){
            println("Eater Interrupted");
        }
        println("Eater Off");
    }
}
public class ToastOMatic{
    public static void main(String[] args)throws Exception{
        ToastQueue dryQueue = new ToastQueue(),
                butterQueue = new ToastQueue(),
                finishedQueue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue,butterQueue));
        exec.execute(new Jammer(butterQueue,finishedQueue));
        exec.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
