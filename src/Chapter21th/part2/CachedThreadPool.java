package Chapter21th.part2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args){
        /**
         * ExecutorService知道如何构建一个恰当的上下文来执行Runnable对象。
         * CachedThreadPool将为每个任务都创建一个线程
         * ExcecutorService对象时使用静态的Executor方法创建的，这个方法可以确定器Executor类型，实际返回的是new ThreadPoolExecutor（）
         */
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0; i<5;i++){
            exec.execute(new LiftOff());
        }
        /**
         * 对shutdown（）方法的调用可以防止新任务被提交给这个Executor，当前线程（本列中，即驱动main（）的线程）将继续运行在shutdown（）被调用之前提交的所有任务
         * 这个程序将在Executor中的所有任务完成之后尽快退出
         */
        exec.shutdown();
        System.out.println("shutdown之后!");
    }
}
