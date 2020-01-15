package Chapter21th.part7th;

import static Utils.StringUtils.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

class Horse implements Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private int strides = 0;
    private static Random rand= new Random(47);
    /**
     * CyclicBarrier适用于这样的情况：你希望创建一组任务，它们并行地执行工作，然后在进行下一个步骤之前等待，直至所有任务完成。它使得所有的并行任务都将在栅栏处列队，因此可以一致地向前移动
     */
    private static CyclicBarrier barrier;
    public Horse(CyclicBarrier barrier){this.barrier = barrier;}
    public synchronized int getStrides(){return strides;}
    public void run(){
        try{
            while(!Thread.interrupted()){
                synchronized (this){
                    strides+=rand.nextInt(3);
                }
                barrier.await();
            }
        }catch (InterruptedException e){
            //合理退出方式
        }catch(BrokenBarrierException e){
            throw new RuntimeException(e);
        }
    }
    public String toString(){
        return "Horse "+id+" ";
    }
    public String tracks(){
        StringBuilder s = new StringBuilder();
        for(int i= 0;i<getStrides();i++){
            s.append("*");
        }
        s.append(id);
        return s.toString();
    }
}

public class HorseRace {
    static final int FINISH_LINE=75;
    private List<Horse> horses = new ArrayList<>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;
    public HorseRace(int nHorse,final int pause){
        /**
         *可以向CyclicBarrier提供一个“栅栏动作”runnable，当计数值到达0时自动执行。这里栅栏动作是作为匿名内部类创建的，它被提供给了CyclicBarrier构造器
         *
         * CyclicBarrier默认的构造方法是CyclicBarrier(int parties)，其参数表示屏障拦截的线程数量，每个线程使用await()方法告诉CyclicBarrier我已经到达了屏障，然后当前线程被阻塞。CyclicBarrier的另一个构造函数CyclicBarrier(int parties, Runnable barrierAction)，用于线程到达屏障时，优先执行barrierAction，方便处理更复杂的业务场景。
         *
         * 
         */
        barrier = new CyclicBarrier(nHorse, new Runnable() {
            @Override
            public void run() {
                StringBuilder s = new StringBuilder();
                for(int i=0;i<FINISH_LINE;i++){
                    s.append("=");
                }
                println(s.toString());
                for(Horse horse:horses){
                    println(horse.tracks());//每个道上的马跑出的距离
                }
                for(Horse horse:horses){//这个循环判断哪个道上的马第一个到达终点
                    if(horse.getStrides()>=FINISH_LINE){
                        println(horse+" won!");
                        exec.shutdownNow();
                        return;
                    }
                }
                try{
                    TimeUnit.MILLISECONDS.sleep(pause);
                }catch(InterruptedException e){
                    println("barrier-action sleep interrupted");
                }
            }

        });
        for(int i= 0;i<nHorse;i++){
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }
    public static void main(String[] args){
        int nHorse = 7;
        int pause= 200;
        if(args.length>0){
            int n = new Integer(args[0]);
            nHorse = n>0?n:nHorse;
        }
        if(args.length>1){
            int p = new Integer(args[1]);
            pause = p > -1?p:pause;
        }
        new HorseRace(nHorse,pause);
    }
}
