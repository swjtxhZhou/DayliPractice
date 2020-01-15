package Chapter21th.part3;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest implements Runnable{
    /**
     * 使用了AtomicInteger而消除了对synchronized关键字
     */
    private AtomicInteger i = new AtomicInteger(0);
    public int getValue(){return i.get();}
    private void evenIncrement(){i.addAndGet(2);}
    public void run(){
        while(true){
            evenIncrement();
        }
    }
    public static void main(String[] args){
        /**
         * 由于整个程序不会失败，所以添加了一个Timer，以便在5秒钟之后自动地终止
         */
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Aborting");
                System.exit(0);
            }
        },5000);//5秒后会终止
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicIntegerTest ato = new AtomicIntegerTest();
        exec.execute(ato);
        while(true){
            int val = ato.getValue();
            if(val%2!=0){//val是奇数时条件为真
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
