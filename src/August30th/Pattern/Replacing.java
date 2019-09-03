package August30th.Pattern;

public class Replacing {
    static String s = Splitting.knights;
    public static void main(String[] args){
        /**
         * String类自带的最后一个正则表达式工具是“替换”。
         * 可以只替换正则表达式第一个匹配的子串，或是替换所有匹配的地方。
         * 第一个匹配的是以f开头，后面跟着一个或多个字母（这里的w是小写），并且只替换第一个匹配的部分
         * 第二个匹配的是三个单词中的任意一个，并且替换所有匹配部分。
         */
        System.out.println(s.replaceFirst("f\\w+","located"));
        System.out.println(s.replaceAll("shrubbery|tree|herring","banana!"));
    }
}
