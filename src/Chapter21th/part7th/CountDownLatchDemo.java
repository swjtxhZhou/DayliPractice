package Chapter21th.part7th;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static Utils.StringUtils.*;

class TaskPortion implements Runnable{
    private static int counter = 0;
    private final int id=counter++;
    private static Random rand = new Random(47);
    /**
     * 它被用来同步一个或多个任务，强制他们!!等待!!有其他任务执行的一组操作完成。
     * 自己理解：能用来让多个线程的任务等待其他多个线程任务的完成，并只使用一个latch。
     *
     * 你可以向CountDownLatch对象设置一个初始技术值，任何在该对象上调用wait（）的方法都将阻塞，直至这个计数值到达0.其他任务在结束其工作时，可以在该对象上调用countDown（）来减小这个计数值。CountDownLatch被设计只触发一次，计数值不能被重置。若需要能够重置计数值的版本，则可以使用CyclicBarrier。
     *
     * 调用countDown（）的任务在产生这个调用时并没有被阻塞，只有对await（）的调用会被阻塞，直至计数值到达0.
     *
     * 典型用用法是将一个程序分为n个互相独立的可解决任务，并创建值为0的CountDownLatch。当每个任务完成时，都会在这个锁存器上调用countDown（）。等待问题被解决的任务在这个锁存器上调用await（），将它们自己拦住，直至锁存器技术结束。
     */
    private final CountDownLatch latch;
    TaskPortion(CountDownLatch latch){this.latch = latch;}
    public void run(){
        try{
            doWork();
            latch.countDown();//减小计数值
        }catch(InterruptedException e){

        }
    }

    private void doWork()throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        println(this+" completed!");
    }
    public String toString(){
        return String.format("%1$-3d", id);
    }
}
class WaitingTask implements Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private final CountDownLatch latch;
    WaitingTask(CountDownLatch latch){
        this.latch = latch;
    }
    public void run(){
        try{
            latch.await();//调用await（）会被阻塞，直至计数值到达0
            println("Latch barrier passed for "+this);
        }catch(InterruptedException e){
            println(this+" interrupted");
        }
    }
    public String toString(){
        return String.format("WaitingTask %1$-3d ",id);
    }
}
public class CountDownLatchDemo {
    static final int SIZE =100;
    public static void main(String[] args)throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(SIZE);
        for(int i = 0;i<10;i++){
            exec.execute(new WaitingTask(latch));//十个等待任务共用一个latch
        }
        for(int i = 0;i<SIZE;i++){
            exec.execute(new TaskPortion(latch));//随机地休眠一段时间，以模拟这部分工作的完成。只有这部分不断地减小latch设置的值直到0，然后waitingTask才能继续其任务，因为调用了latch。await（）。
        }
        println("launched all tasks");
        exec.shutdown();
    }
}
/**
 *
 */
