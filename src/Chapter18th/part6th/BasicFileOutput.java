package Chapter18th.part6th;

import java.io.*;

//基本文件输出
public class BasicFileOutput {
    static String file = "BasicFileOutput.out";
    public static void main(String[] args)throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("D:\\practie\\DayliPractice\\src\\Chapter18th\\part6th\\BasicFileOutput.java")));
        /**
         * FileWriter对象可以向文件写入数据。
         * 首先创建一个与指定文件连接的FileWriter。
         * 通常会用BufferedWriter将其包装起来用以缓冲输出（缓冲往往能显著地增加i/o操作的性能）
         * 本例中它被装饰成PrintWriter，这种方式创建的数据文件可作为普通文本文件读取
         */
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while((s=in.readLine())!=null){
            out.println(lineCount+++": "+s);//往文件中一行一行写入

        }
        /**
         * out显式地调用close（）。若没有这样做，就会发现缓冲区内容不会被刷新清空，那么他们也就不完整
         */
        out.close();
        System.out.println("读取文件： "+BufferedInputFile.read(file));
    }
}
