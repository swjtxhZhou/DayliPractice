package Chapter21th.part2;

import java.util.concurrent.TimeUnit;

public class SimpleDaemon implements Runnable{
    public void run(){
        try{
            while(true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+" "+this);
            }
        }catch(InterruptedException e){
            System.out.println("sleep() interrupted");
        }
    }
    public static void main(String[] args)throws Exception{
        for(int i=0;i<10;i++){
            Thread daemon = new Thread(new SimpleDaemon());
            /**
             * 所谓后台（daemon）线程，是指在程序运行的时候在后台提供一种通用服务的线程，并且这种线程并不属于程序中不可或缺的部分
             * 因此，当所有的非后台程序结束时，程序也就终止了，同时会杀死进程中的所有后台线程。反过来说，只要有任何非后台线程还在运行，程序就不会终止
             * main就是一个非后台程序线程
             * 必须在线程启动之前调用setDaemon（）方法，才能把它设置为后台程序
             * 一旦main完成了其工作，就没什么能阻止程序终止了
             */
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All daemon started");
        TimeUnit.MILLISECONDS.sleep(75);
    }
}
