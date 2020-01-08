package Chapter21th.part2.part3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable{
    private volatile int i = 0;
    public synchronized int getValue(){
        /**
         * return i 是原子操作，但是缺少同步使得其数值可以在处于不稳定的的中间状态被读取。
         * 除此之外i不是volatile的，因此还存在可视性问题
         * getValue（）和evenIncrement()必须是synchronized
         */
        return i;
    }
    private synchronized void evenIncrement(){
        i++;
        i++;
    }
    public void run(){
        while(true){
            evenIncrement();
        }
    }
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at =  new AtomicityTest();
        exec.execute(at);
        while(true){
            int val = at.getValue();
            if(val%2!=0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
