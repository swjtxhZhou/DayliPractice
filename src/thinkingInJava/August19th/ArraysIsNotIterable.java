package thinkingInJava.August19th;

import java.util.Arrays;

public class ArraysIsNotIterable {
    /**
     * <T>这个T是个修饰符的功能，表示是个泛型方法，就像有static修饰的方法是个静态方法一样。
     *
     * <T> 不是返回值，表示传入参数有泛型
     * @param ib
     * @param <T>
     */
    static <T> void test(Iterable<T> ib){
        for(T t:ib){
            System.out.println(t+" ");
        }
    }
    public static void main(String[] args){
        test(Arrays.asList(1,2,3));
        String[] strings = {"thinkingInJava.A","B","C"};
        test(Arrays.asList(strings));
    }
}
