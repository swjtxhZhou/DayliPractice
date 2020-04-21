package thinkingInJava.Chapter21th.part2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class ExceptionThread2 implements Runnable{
    public void run(){
        Thread t = Thread.currentThread();
        System.out.println("run by "+t);
        System.out.println("eh= "+t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    public void uncaughtException(Thread t , Throwable e){
        System.out.println("caught "+e);
    }
}

class HandleThreadFactory implements ThreadFactory{
    /**
     * 该方法会返回一个新的线程
     * 这个线程设置了处理Exception的方法，就是我们实现了Thread.UncaughtExceptionHandler接口，而自己创建的异常捕获处理类
     * 这个类会把异常打印出来。即使没有run（）中设置捕获
     * @param r
     * @return
     */
    public Thread newThread(Runnable r){
        System.out.println(this+" creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created "+t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = "+t.getUncaughtExceptionHandler());
        return t;
    }
}

public class CaptureUncaughtException {
    public static void main(String[] args){
        /**
         * 修改Executor产生线程的方式，Thread.UncaughtExceptionHandler。uncaughtException（）会在线程因未捕获的异常而临近死亡时而被调用
         */
        ExecutorService exec = Executors.newCachedThreadPool(new HandleThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}
