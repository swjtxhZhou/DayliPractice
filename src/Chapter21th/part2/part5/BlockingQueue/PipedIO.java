package Chapter21th.part2.part5.BlockingQueue;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static Utils.StringUtils.*;

/**
 * 通过输入输出在线程间进行通通常很有用。提供线程功能的类库以“管道”的形式对线程间的输入输出提供了支持。对应物就是pipedWriter类（允许任务向管道写）和pipedReader（允许不同任务从同一个管道中读取）。管道基本上是一个阻塞队列
 */
class Sender implements Runnable{
    private Random random = new Random(47);
    private PipedWriter out = new PipedWriter();
    public PipedWriter getPipedWriter(){return out;}
    public void run(){
        try{
            while(true){
                for(char c ='A';c<='z';c++){
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
                }
            }
        }catch(IOException e){
            println(e+" Sender write exception");
        }catch(InterruptedException e){
            println(e+" Sender sleep interrupted");
        }
    }
}
class Receiver implements Runnable{
    private PipedReader in;
    public Receiver(Sender sender)throws  IOException{
        in = new PipedReader(sender.getPipedWriter());
    }
    public void run(){
        try{
            while(true){
                println("Read: "+(char)in.read()+", ");
            }
        }catch(IOException e){
            println(e+" Reciever read exception");
        }
    }
}
public class PipedIO {
    public static void main(String[] args)throws Exception{
        /**
         * sender和receiver代表了需要互相通信的两个任务。Sender创建了一个pipedWriter，它是一个单独的对象；但是对于Receiver，pipedReader的建立必须在构造器中与一个pipedWriter相关联
         *
         * 在shutdownNow（）被调用时，可以看到PipedReader与普通i/o之间最重要的差异是--pipedReader是可中断的。
         */
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
}
