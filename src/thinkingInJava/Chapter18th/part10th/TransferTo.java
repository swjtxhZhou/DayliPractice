package thinkingInJava.Chapter18th.part10th;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class TransferTo {
    public static void main(String[] args)throws Exception{
        if(args.length!=2){
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }
        FileChannel in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();
        /**
         * 特殊方法transferTo（）和transferFrom（）则允许我们将一个通道和一个通道直接相连
         */
        in.transferTo(0,in.size(),out);
    }
}
