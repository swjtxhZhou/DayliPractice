package thinkingInJava.Pattern;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * split()方法将输入字符串断开成字符串对象数组，断开边界由正则表达式确定
 */
public class SplitDemo {
    public static void main(String[] args){
        String input = "This!!unusual use!!of exclamation!!points";
        System.out.println(Arrays.toString(Pattern.compile("!!").split(input)));
        System.out.println(Arrays.toString(Pattern.compile("!!").split(input,3)));//限制输入分割字符串的数量
//        System.out.println(Pattern.compile("!!").split(input));这会打印String数组对象引用的地址

    }
}
