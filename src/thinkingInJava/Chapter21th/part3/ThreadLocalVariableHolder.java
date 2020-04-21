package thinkingInJava.Chapter21th.part3;


import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Accessor implements Runnable{
    private final int id;
    public Accessor(int id){this.id = id;}
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }
    public String toString(){
        return "#"+id+": "+ThreadLocalVariableHolder.get();
    }
}
public class ThreadLocalVariableHolder {
    /**
     * 线程本地存储是一种自动化机制，可以为使用相同变量的每个不同的线程都创建不同的存储，若有5个线程都要使用变量x锁表示的对象，那线程本地存储就会生成5个用于x的不同的存储块
     *  ThreadLocal对象通常当作静态域存储。在创建ThreadLocal时，你只能通过get（）和set（）方法来访问该对象的内容
     *  其中get（）方法返回与其线程相关联的对象的副本，而set（）会将参数插入到为其线程存储的对象中，并返回存储中原有的对象。
     *  increment和get方法都不是synchronized的，因为ThreadLocal保证不会出现竞争条件
     */
    private static ThreadLocal<Integer> value=new ThreadLocal<Integer>(){
        private Random rand=new Random(47);
        protected synchronized Integer initialValue(){
            return rand.nextInt(10000);
        }
    };
    public static void increment(){
        value.set(value.get()+1);
    }
    public static int get(){
        return value.get();
    }
    public static void main(String[] args)throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        /**
         * 当运行这个程序时，你可以看到每个单独的线程都被分配了自己的存储，因为他们每个都需要跟踪自己的计数值，即便只有一个ThreadLocalVariableHolder对象
         */
        for(int i= 0;i<5;i++){
            exec.execute(new Accessor(i));
        }
        TimeUnit.SECONDS.sleep(3);
        /**
         * shutdown只是将线程池的状态设置为SHUTWDOWN状态，正在执行的任务会继续执行下去，没有被执行的则中断。而shutdownNow则是将线程池的状态设置为STOP，正在执行的任务则被停止，没被执行任务的则返回。
         */
        exec.shutdownNow();
    }
}
