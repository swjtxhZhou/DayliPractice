package Chapter21th.part2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args){
        /**
         * 有了FixedThreadPool，就可以一次性预先执行代价高昂的线程分配，因而就可以限制线程的数量了
         * 这可以节省时间，！！！注意，在线程池中，现有线程在可能的情况下，都会被复用
         * CachedThreadPool在程序执行过程中，通常会创建与所需要数量相同的线程，然后它在回收旧线程时停止创建新线程，因此事Executor的首选
         * 其次才是考虑使用FixedThreadPool
         */
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for(int i=0; i<6;i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
