package August30th.Pattern;

import java.util.Arrays;

/**
 * split()方法，其功能是将“字符串从正则表达式匹配的地方切开”
 */
public class Splitting {
    public static String knights = "then you have found the shrubbery, you must "+"cut down the mightiest tree in the forest..."+"with... a herring";
    public static void split(String s){
        System.out.println(Arrays.toString(knights.split(s)));
    }
    public static void main(String[] args){
        /**
         * 按空格划分字符
         */
        split(" ");
        /**
         * \W表示非单词字符（\w表示一个单词字符）
         * 第二个列子将标点删除了
         */
        split("\\W+");
        /**
         * 字母n后面跟着一个或者多个非单词字符
         * 原始字符串中，与正则表达式匹配的部分在最终结果否不存在了。
         */
        split("n\\W+");
    }
}
