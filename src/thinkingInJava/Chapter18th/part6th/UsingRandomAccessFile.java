package thinkingInJava.Chapter18th.part6th;

import java.io.IOException;
import java.io.RandomAccessFile;

public class UsingRandomAccessFile {
    static String file = "rtest.dat";

    /**
     * display()打开了一个文件，以double值的形式显示了其中的七个元素。
     * @throws IOException
     */
    static void display()throws IOException{
        RandomAccessFile rf = new RandomAccessFile(file,"r");
        for(int i=0;i<7;i++){
            System.out.println("Value "+i+" : "+rf.readDouble());
        }
        System.out.println(rf.readUTF());
        rf.close();
    }
    public static void main(String[] args)throws IOException{
        /**
         * RandomAccessFile不支持装饰，所以不能将其与InputStream及OutputStream子类的任何部分组合起来。我们必须假定它已经被正确缓冲，因为我们不能为它添加这样的功能
         */
        RandomAccessFile rf = new RandomAccessFile(file,"rw");
        for(int i = 0;i<7;i++){
            rf.writeDouble(i*1.414);
        }
        rf.writeUTF("the end of the file");

        rf.close();
        display();

        rf = new RandomAccessFile(file,"rw");
        /**
         * 因为double总是8字节长，所以为了用seek（）查找第五个双精度，用5*8来查找位置。
         */
        rf.seek(5*8);
        rf.writeDouble(47.0001);
        rf.close();
        display();
    }
}
