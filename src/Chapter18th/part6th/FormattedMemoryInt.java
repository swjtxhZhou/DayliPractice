package Chapter18th.part6th;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class FormattedMemoryInt {
    public static void main(String[] args)throws IOException {
        try{
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("D:\\practie\\DayliPractice\\src\\Chapter18th\\part6th\\FormattedMemoryInt.java").getBytes()));
            while(true){
                /**
                 * y用readByte（）一次一个字节地读取字符，那么任何字节的值都是合法的结果，因此返回值不能用来检测输入是否结束
                 */
                System.out.println((char) in.readByte());
            }
        }catch (EOFException e){
            System.err.println("out of stream");
        }
    }
}
