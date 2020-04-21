package thinkingInJava.Chapter18th.part6th;

import java.io.IOException;
import java.io.StringReader;

/**
 * 从内存输入
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("D:\\practie\\DayliPractice\\src\\thinkingInJava.Chapter18th\\part6th\\BufferedInputFile.java"));
        int c;
        while((c=in.read())!=-1){
            /**read是以int形式返回下一个字节。因此必须类型转换为char才能正确打开
             *
             */
            System.out.println((char)c);
        }
    }
}
