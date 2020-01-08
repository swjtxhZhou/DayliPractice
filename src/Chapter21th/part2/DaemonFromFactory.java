package Chapter21th.part2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable{
    public void run(){
        try{
            while(true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+" "+this);
            }
        }catch (InterruptedException e){
            System.out.println("Interrupt!");
        }
    }
    public static void main(String[] args)throws Exception{
        /**
         *  之后运行Runnable都会从DaemonThreadPool中取新的线程
         *  新的线程在启动之前就已经把setDaemon设置为true了
         */

        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for(int i=0;i<10;i++){
            exec.execute(new DaemonFromFactory());
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
