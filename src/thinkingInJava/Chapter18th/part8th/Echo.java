package thinkingInJava.Chapter18th.part8th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * System.in是一个没有被包装过的未经加工的InputStream。在使用之前必须对其进行包装
 * 通常会用readLine（）一次一次地读取输入，我们将System.in包装成BufferedReader来使用，这就要求我们必须用InputStreamReader把System。in转换成Reader
 */
public class Echo {
    public static void main(String[] args)throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=stdin.readLine())!=null&&s.length()!=0){
            System.out.println(s);
        }
    }
}
