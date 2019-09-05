package Septemper2th;

import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * 自定义正则表达式进行扫描，这在扫描复杂的数据是非常有用
 * 这是扫描一个防火墙日志文件中记录的威胁数据。
 */
public class ThreatAnalyzer {
    static String threatData = "58.27.82.161@02/10/2005\n"+"204.45.234.40@02/11/2005\n"+"58.27.82.161@02/11/2005\n"+"58.27.82.161@02/12/2005\n"
            +"58.27.82.161@02/12/2005\n"+"[Next log section with different data format]";
    public static void main(String[] args){
        String pattern ="(\\d+[.]\\d+[.]\\d+[.]\\d+)@"+"(\\d{2}/\\d{2}/\\d{4})";
        Scanner scanner= new Scanner(threatData);
        while(scanner.hasNext(pattern)){
            /**
             * 当next（）方法配合指定的正则表达式使用时，将找到下一个匹配该模式的输入部分，调用match方法就可以获得匹配的结果
             * 在配合正则表达式使用扫描时，有一点需要注意：它仅仅针对下一个输入分词进行匹配，如果你的正则表达式有定界符，那永远不可能匹配成功。
             */
            scanner.next(pattern);
            MatchResult match = scanner.match();
            String ip = match.group(1);
            String date = match.group(2);
            System.out.format("Threat on %s from %s\n",date,ip);
        }
    }

}
