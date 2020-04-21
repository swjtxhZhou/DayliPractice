package thinkingInJava.Chapter21th.part2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
    public static void main(String[] args){
        /**
         * SingleThreadExecutor就是线程数量为1的FixedThreadPool，
         * 这对于你希望在另一个线程中连续运行的任何事物（长期存活的任务）来说，都是很有用的。
         * 如果向他提交了多个任务，那么这些任务将排队，每个任务都会在下一个任务开始之前运行结束，所有的任务将使用相同的线程。
         */
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int  i=0; i<5;i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
