package thinkingInJava.Chapter18th.part10th;

import java.nio.ByteBuffer;

public class GetData {
    private static final int BSIZE = 1024;
    public static void main(String[] args){
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        int i =0;
        while(i++ < bb.limit()){//查看缓冲器的分配方式是否将其内容自动置零
            if(bb.get()!=0){
                System.out.println("nonzero");
            }
            System.out.println("i= "+i);
        }

        /**
         * 尽管ByteBuffer只能保存字节类型的数据，但是它可以具有可以从其所容纳的字节中产生出各种不同基本类型值的方法
         */
        bb.rewind();//调用该方法返回到数据开始部分
        bb.asCharBuffer().put("Howdy!");
        char c;
        while((c = bb.getChar())!=0){
            System.out.println(c+" ");
        }

        bb.rewind();
        bb.asShortBuffer().put((short)471142);
        System.out.println(bb.getShort());

        bb.rewind();
        bb.asLongBuffer().put(99471142);
        System.out.println(bb.getLong());

        bb.rewind();

    }
}
