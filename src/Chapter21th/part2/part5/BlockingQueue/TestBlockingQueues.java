package Chapter21th.part2.part5.BlockingQueue;

import Chapter21th.part2.LiftOff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

import static Utils.StringUtils.*;

/**
 * 使用同步队列来解决任务协作问题，同步队列在任何时刻都只允许一个任务插入或移除元素。
 * 如果消费者任务试图从队列中获取对象，而该队列此时为空，那么这些队列还可以挂起消费者任务，并且当有更多得元素可用时恢复消费者任务。阻塞队列可以解决非常大量得问题,而其方式与wait（）和notifyAll（）相比，则简单并可靠的多
 *
 * 下面将多个LiftOff对象得执行串行化了。消费者时LiftOffRunner，它将每个LiftOff对象从BlockingQueue中推出并直接运行（通过显式地调用run（）而使用自己得线程来运行，而不是为每个任务启动一个新线程）
 */

class LiftOffRunner implements Runnable{
    private BlockingQueue<LiftOff> rockets;
    public LiftOffRunner(BlockingQueue<LiftOff> queue){
        rockets = queue;
    }
    public void add(LiftOff lo){
        try{
            rockets.put(lo);
        }catch(InterruptedException e){
            println("Interrupted during put()");
        }
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        }catch(InterruptedException e){
            println("waking from take()!");
        }
        println("exiting LiftOffingRunner!");
    }
}
public class TestBlockingQueues {
    static void getKey(){
        try{
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    static void getKey(String message){
        println(message);
        getKey();
    }
    static void test(String msg,BlockingQueue<LiftOff> queue){
        println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for(int i= 0;i<5;i++){
            runner.add(new LiftOff(5));
        }
        getKey("press 'enter' ("+msg+")");
        t.interrupt();//按回车键就会触发中断
        println("Finished "+msg+" test");
    }
    public static void main(String[] args){
        test("LinkedBlockingQueue",new LinkedBlockingQueue<LiftOff>());//不限制数量
        test("ArrayBlockingQueue",new ArrayBlockingQueue<LiftOff>(3));//固定数量3
        test("SynchronousQueue",new SynchronousQueue<LiftOff>());//数量为1
    }

}
