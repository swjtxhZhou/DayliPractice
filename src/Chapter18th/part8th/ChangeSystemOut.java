package Chapter18th.part8th;

import java.io.PrintWriter;

public class ChangeSystemOut {
    public static void main(String[] args){
        /**
         * System.out是一个PrintStream，而PrintStream是一个OutputStream。
         * PrintWriter有一个可以接受OutputStream最为参数的构造器。只要需要就能使用哪个构造器把System.out转化成PrintWriter
         */
        PrintWriter out = new PrintWriter(System.out,true);//使用有两个参数的PrintWriter构造器，并将第二个设置为true，一边开启自动清空功能，否则可能看不到输出
        out.println("Hello,World");
    }
    public static void print(String s){
        PrintWriter out = new PrintWriter(System.out,true);
        out.println(s);
    }
}
