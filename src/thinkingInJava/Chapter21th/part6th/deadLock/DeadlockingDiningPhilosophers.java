package thinkingInJava.Chapter21th.part6th.deadLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DeadlockingDiningPhilosophers {
    public static void main(String[] args)throws Exception{
        /**
         * 若哲学家花费更多的时间去思考而不是进餐（使用非0的ponder值，或者大量的Philosopher），那么他们请求公共资源（Chopstick）的可能性就会小很多，发生死锁的可能性就很小。
         *
         * 要修正死锁问题，必须明白，当以下四个条件满足时就会发生死锁：
         * 1，互斥条件。任务使用的资源至少有一个是不能共享的。（这里一根筷子同一个时刻只能被一个philosopher使用。）
         * 2,至少有一个任务必须持有一个资源且正在等待获取一个当前被别的任务持有的资源。（要发生死锁，philosopher必须拿着一根Chopstick并且等待另一根）
         * 3，资源不能被任务抢占，任务必须把资源释放当做普通事件。（philosopher很有礼貌，他们不会从其他Philosopher那里抢占Chopstick）
         * 4，必须有循环等待，这时，一个任务等待其他任务所持有的资源，后者又在等待另一个任务所持有的资源，这样一直下去，直到有一个任务在等待第一个任务所持有的资源，使得大家都被锁住。（每个Philosopher都试图先得到右边的Chopstick，然后得到左边的Chopstick，所以发生了循环等待）
         *
         * 要防止死锁的话只需要破坏其中一个即可。
         * 在程序中，最容易的方法是破坏第四个条件
         */
        int ponder = 5;
        if(args.length>0){
            ponder = Integer.parseInt(args[0]);
        }
        int size = 5;
        if(args.length>1){
            size = Integer.parseInt(args[1]);
        }
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[size];
        for(int i = 0;i<size;i++){
            sticks[i] = new Chopstick();
        }
        for(int i= 0; i<size;i++){
            exec.execute(new Philosopher(sticks[i],sticks[(i+1)%size],i,ponder));
        }
        if(args.length ==3 && args[2].equals("timeout")){
            TimeUnit.SECONDS.sleep(5);
        }else{
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
}
