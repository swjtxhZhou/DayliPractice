package Chapter21th.part4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static Utils.StringUtils.*;

class NIOBlocked implements Runnable{
    private final SocketChannel sc;
    public NIOBlocked(SocketChannel sc){
        this.sc = sc;
    }
    public void run(){
        try{
            println("Waiting for read() in "+this);
            sc.read(ByteBuffer.allocate(1));
        }catch(ClosedByInterruptException e){
            println("ClosedByInterruptException");
        }catch(AsynchronousCloseException e){
            println("AsynchonousCloseException");
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        println("Exiting NIOBlocked.run() "+this);
    }
}

public class NIOInterruption {
    public static void main(String[] args)throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080);
        InetSocketAddress isa = new InetSocketAddress("localhost",8080);
        SocketChannel sc1 = SocketChannel.open(isa);
        SocketChannel sc2 = SocketChannel.open(isa);
        Future<?> f = exec.submit(new NIOBlocked(sc1));
        exec.execute(new NIOBlocked(sc2));
        /**
         * 可以关闭底层资源以释放锁，尽管这一做法一般不是必需的。
         * 使用exec.shutdownNow()将可以很荣誉地终止所有事物
         * 对于捕获示例中地Future，只有在将中断发送给一个线程，同时不发送给另一个线程时才是必需地。
         */
        exec.shutdown();
        TimeUnit.SECONDS.sleep(1);
        f.cancel(true);//通过通道来产生一个阻断
        TimeUnit.SECONDS.sleep(1);
        sc2.close();//通过关闭通道来释放阻塞。
    }
}
