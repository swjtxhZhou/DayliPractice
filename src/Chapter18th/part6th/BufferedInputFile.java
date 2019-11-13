package Chapter18th.part6th;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
    public static String read(String filename) throws IOException{
        /**
         * 打开一个文件用于字符输入，可以使用以String或File对象作为文件名的FileInputReader。
         * 为了提高速度，我们希望对那个文件进行缓冲，将所产生的应用给一个BufferedReader构造器，其也提供readLine方法，这是我们最终对象和进行读取的接口。
         * 当ReadLine==null时表示已经到了文件的末尾。
         */
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine())!=null) {
            sb.append(s+"\n");//readLine（）会把文件中的换行符全部删掉
        }
        in.close();//关闭文件
        return sb.toString();
    }
    public static void main(String[] args) throws IOException{
        System.out.println(read("D:\\practie\\DayliPractice\\src\\Chapter18th\\part6th\\BufferedInputFile.java"));
    }
}
