package thinkingInJava.Pattern;

/**
 * 部分常用表达式，JDK文档中java.util.regex.Pattern
 */
public class Rudolph {
    public static void main(String[] args){
        for(String pattern:new String[]{"Rudolph","[rR]udolph","[rR][aeiou][a-z]ol.*","R.*"})
            System.out.println("Rudolph".matches(pattern));
    }
}
