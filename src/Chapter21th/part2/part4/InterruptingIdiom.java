package Chapter21th.part2.part4;
import java.util.concurrent.TimeUnit;

import static Utils.StringUtils.*;
class NeedsCleanup{
    private final int id;
    public NeedsCleanup(int ident){
        id = ident;
        println("NeedsCleanup "+id);
    }


    public void cleanup(){
        println("Cleaning up "+id);
    }
}
class Blocked3 implements Runnable{
    private volatile double d = 0.0;

    /**
     * 你可以调用interrupted（）来检查中断状态，这不仅可以告诉你interrupt（）是否被调用过，而且还可以清除中断状态。
     * 清除中断状态可以确保并发结构不会就某个任务被中断这个问题通知你两次。
     * 你可以经由单一的InterruptedException或单一的成功的Thread.interrupted()测试来得到这种通知
     * 如果想要再次检查以了解是否被中断，则可以在调用Thread.interrupted()时将结果存储起来
     */
    public void run(){
        try{
            /**
             * 如果interrupt（）在注释point2之后（即在非阻塞的操作过程中）被调用，那么首先循环将结束，然后所有的本地对象将被销毁，
             * 最后循环会经由while语句的顶部退出。
             * 若interrupt（）在point1和point2之间（在while语句之后，但是在阻塞操作sleep（）之前或者过程中）被调用，
             * 那么这个任务就会在第一次试图调用阻塞操作之前，经由InterruptedException退出。
             * 在这种情况下，在异常被抛出之时唯一被创建出来的NeedsCleanup对象将被清除，而你也就有了在catch子句中执行其他任何清除工作的机会。
             */
            println("interrupted(): "+!Thread.interrupted());
            while(!Thread.interrupted()){
                //point1
                NeedsCleanup n1 = new NeedsCleanup(1);
                try{
                    println("Sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    //point2
                    NeedsCleanup n2 = new NeedsCleanup(2);
                    try{
                        println("Calculating");
                        for(int i = 1;i<2500000;i++){
                            d = d+(Math.PI+Math.E)/d;
                        }
                        println("Finished time-consuming operation");
                        /**
                         *经由异常离开循环时，正确清理资源的必要性
                         */
                    }finally {
                        n2.cleanup();
                    }
                }finally {
                    n1.cleanup();
                }
            }
            println("Exiting via while() test");
        }catch(InterruptedException e){
            println("Exiting via InterruptedException");
        }
    }
}

public class InterruptingIdiom {
    public static void main(String[] args)throws Exception{
//        println("args.length= "+args.length);
        /**
         * 必须给程序提供一个命令行参数，来表示在它调用interrupt（）之前以毫秒为单位的延迟时间。
         * 通过使用不同的延迟，你可以在不同地点退出Blocked3.run（）
         */
//        if(args.length !=1){
//            println("usage: java TnterruptingIdiom delay-in-mS");
//            System.exit(1);
//        }
        Thread t = new Thread(new Blocked3());
        t.start();
//        println("args[0]="+args[0]);
//        TimeUnit.MILLISECONDS.sleep(1000);
        /**
         * 被设计用来响应interrupt（）的类必须建立一种策略，来确保它将保持一致的状态。这通常一位着所有需要清理的对象创建操作的后面，必须紧跟try—catch子句
         * 从而使得无论run（）循环如何退出，清理都会发生。
         */
        t.interrupt();
        println("main:interrupted(): "+Thread.currentThread().interrupted());
    }
}
