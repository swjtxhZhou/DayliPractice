package thinkingInJava.Pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerMatch {
    public static void main(String[] args){
        /**
         * 可能有一个负号，后面跟着一位或多位数字
         */
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        /**
         * 这个正则表达式表示字符的起始字符可能是一个-或+，或二者都没有（因为后面跟着？修饰符）。
         * 字符+在正则表达式中有特殊的意义，所以必须使用\\将其转义，使之成为表达式中的一个字符。
         */
        System.out.println("+911".matches("(-|\\+)?\\d+"));
        System.out.println("+911".matches("(-|\\+)?"+"911"));


        String a = "BD213-1";
        Pattern p = Pattern.compile("D\\d+");
        Matcher m = p.matcher(a);
        while(m.find()){
            System.out.println("查找到得字符："+m.group());
        }
    }
}
