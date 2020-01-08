package Chapter21th.part2.part4;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static Utils.StringUtils.*;

/**
 * 一旦底层资源被关闭，任务将解除阻塞，interrupt（）看起来发生在关闭Socket而不是关闭System.in的时刻
 */
public class CloseResource {
    public static void main(String[] args)throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080);
        InputStream socketInput = new Socket("localhost",8080).getInputStream();
        exec.execute(new IOBlocked(socketInput));
        exec.execute(new IOBlocked(System.in));
        TimeUnit.MILLISECONDS.sleep(100);
        println("Shuting down all the Threads");
        exec.shutdownNow();
        TimeUnit.SECONDS.sleep(1);
        println("Closing "+socketInput.getClass().getName());
        /**
         * 关闭任务在其上发生阻塞的底层资源
         */
        socketInput.close();
        TimeUnit.SECONDS.sleep(1);
        println("Closing "+System.in.getClass().getName());
        System.in.close();
    }
}
