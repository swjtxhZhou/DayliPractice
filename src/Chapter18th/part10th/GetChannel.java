package Chapter18th.part10th;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
    private static final int BSIZE = 1024;
    public static void main(String[] args)throws Exception{
        /**
         * getChannel()将会产生一个FileChannel。
         * 可以使用通道传送用于读写的ByteBuffer，并且可以锁定文件的某些区域用于独占式访问
         *
         */
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        /**
         * 将字节存放再ByteBuffer的方法之一是用“put”直接对他们进行填充
         * 也可以使用warp（）方法将已存在的字节数组包装到ByteBuffer中
         */
        fc.write(ByteBuffer.wrap("some text".getBytes()));
        fc.close();
        /**
         * data.txt文件用RandomAccessFile被再次打开，我们可以在文件内随处移动FileChannel
         * 这里我们把它移动到最后
         */
        fc = new RandomAccessFile("data.txt","rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap(" some more".getBytes()));
        fc.close();
        /**
         * 对于只读访问，我们必须显示地使用静态的allocate（）方法来分配ByteBuffer
         * nio的目标就是快速地移动大量数据，因此ByteBuffer的大小就显得尤为重要（这里使用的是1k）
         * 一旦调用read（）来告知FileChannel向ByteBuffer存储字节，就必须调用缓冲器尚的flip（），让它做好准备让别人来读取字节的准备（他很拙劣，却适用于获取最大的速度）
         */
        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while(buff.hasRemaining()){
            System.out.print((char)buff.get());
        }
    }
}
