package Chapter18th.part10th;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
    private static final int BSIZE = 1024;
    public static void main(String[] args)throws Exception{
        if(args.length != 2){
            System.out.println("arguments: sourceFile destfile");
            System.exit(1);
        }
        /**
         * 一个通道用于读，一个用于写
         * ByteBuffer被分配了空间，当FileChannel返回-1时，表示我们已经到达了输入的末尾。
         * 每次read（）操作之后，就会将数据输入到缓冲器以便它的信息可以由write提取。
         * write（）操作之后，信息仍在缓冲器中，接着clear（）操作则堆所有的内部指针重新安排，以便缓冲器再另一个read（）操作期间能够做好接受数据的准备
         */
        FileChannel in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        while (in.read(byteBuffer)!=-1){//
            byteBuffer.flip();
            out.write(byteBuffer);
            byteBuffer.clear();
        }
    }
}
