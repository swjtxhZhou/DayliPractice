package Chapter21th.part2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff{
    public void run(){
        try{
            while(countDown-- >0){
                System.out.println(status());
                /**
                 * sleep()的调用可能会抛出InterruptException异常
                 * 它在异常中被捕获，因为异常不能跨线程传播回main（），所以必须在本地处理所有在任务内部产生的异常。
                 */
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        }catch(InterruptedException e){
            System.err.println("Interrupt!");
        }
    }
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0; i<5;i++){
            /**
             * 打印出来的顺序根据不同的操作系统的底层有关
             */
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
