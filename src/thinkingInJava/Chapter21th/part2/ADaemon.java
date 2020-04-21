package thinkingInJava.Chapter21th.part2;

import java.util.concurrent.TimeUnit;

public class ADaemon implements Runnable {
    public void run(){
        try{
            System.out.println("Starting ADaemon!");
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            System.out.println("Exiting via InterruptedException");
        }finally {
            System.out.println("this should be always run?");
        }
    }
    public static void main(String[] args)throws Exception{
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
        /**
         * 后台进程可能会在不执行finally的情况下就会终止run（）方法
         * 非后台的Executor通常是一种更好的方式，因为Executor控制的所有任务可以同时被关闭
         */
        TimeUnit.MILLISECONDS.sleep(100);
    }
}
