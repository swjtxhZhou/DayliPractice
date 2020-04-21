package thinkingInJava.August20th;

import thinkingInJava.part1.part5_innerClasses.Parcel8;

/**
 * JAVA允许生成空白final，即为给定初值的域。
 * 无论什么情况，编译器都确保空白final在使用前必须初始化。
 * 空白final提供了更大的灵活性
 */
public class BlankFinal {
    private final int i = 0;
    private final int j;
    private final Parcel8 p;

    /**
     * 必须在域的定义处或者每个构造器中用表达式对final进行赋值
     */
    public BlankFinal(){
        j = 1;
        p= new Parcel8();
    }
    public BlankFinal(int x){
        j = x;
        p = new Parcel8();
    }
    public static void main(String[] args){
        new BlankFinal();
        new BlankFinal(47);
    }
}
