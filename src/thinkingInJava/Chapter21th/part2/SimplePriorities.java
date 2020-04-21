package thinkingInJava.Chapter21th.part2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePriorities implements Runnable{
    private int countDown = 5;
    private volatile double d;
    private int priority;
    public SimplePriorities(int priority){
        this.priority = priority;
    }
    public String toString(){
        return Thread.currentThread()+": "+countDown;
    }
    public void run(){
        /**
         * 优先级在run（）的开头声明的，在构造器中设置他们不会有任何好处，因为Executor在此刻还没有开始执行任务
         */
        Thread.currentThread().setPriority(priority);
        while(true){
            for(int i=1;i<100000;i++){
                d += (Math.PI+Math.E)/(double)i;
                if(i%1000==0){
                    Thread.yield();
                }
            }
            System.out.println(this);
            if(--countDown==0){
                return;
            }
        }
    }
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0; i<5;i++){
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}
