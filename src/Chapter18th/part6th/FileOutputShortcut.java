package Chapter18th.part6th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class FileOutputShortcut {
    static String file = "FileOutputShortcut.out";
    public static void main(String[] args)throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("D:\\practie\\DayliPractice\\src\\Chapter18th\\part6th\\FileOutputShortcut.java")));
        /**
         * java5添加了一个辅助构造器，不必每次创建文本文件并向其中写入时，都去执行所有的装饰工作。
         * 但其他的常见写入任务都没有快捷方式
         */
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while((s=in.readLine())!=null){
            out.println(lineCount++ +": "+s);
        }
        out.close();
        System.out.println("读取文件： "+BufferedInputFile.read(file));
    }
}
