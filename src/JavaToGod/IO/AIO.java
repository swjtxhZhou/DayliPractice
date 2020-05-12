package JavaToGod.IO;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AIO {
    //同样有管道（channel）和缓冲区（Buffer）
    public static void main(String[] args) throws Exception {
        Path file = Paths.get("/usr/a.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(file);

        ByteBuffer buffer = ByteBuffer.allocate(100_000);//限定缓冲区的大小
        //会使用一个Future的类来接受通知，并读取拷贝好的内容
        Future<Integer> result = channel.read(buffer, 0);

        while (!result.isDone()) {
            ProfitCalculator.calculateTax();
        }
        Integer bytesRead = result.get();
        System.out.println("Bytes read [" + bytesRead + "]");
    }
}
class ProfitCalculator {
    public ProfitCalculator() {
    }
    public static void calculateTax() {
    }
}

 class WriteToFile {

    public static void main(String[] args) throws Exception {
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
                Paths.get("/asynchronous.txt"), StandardOpenOption.READ,
                StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        CompletionHandler<Integer, Object> handler = new CompletionHandler<Integer, Object>() {

            @Override
            public void completed(Integer result, Object attachment) {
                System.out.println("Attachment: " + attachment + " " + result
                        + " bytes written");
                System.out.println("CompletionHandler Thread ID: "
                        + Thread.currentThread().getId());
            }

            @Override
            public void failed(Throwable e, Object attachment) {
                System.err.println("Attachment: " + attachment + " failed with:");
                e.printStackTrace();
            }
        };

        System.out.println("Main Thread ID: " + Thread.currentThread().getId());
        fileChannel.write(ByteBuffer.wrap("Sample".getBytes()), 0, "First Write",
                handler);
        fileChannel.write(ByteBuffer.wrap("Box".getBytes()), 0, "Second Write",
                handler);

    }
}
