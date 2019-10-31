package October10th.ErasedType;

import java.util.ArrayList;

/**
 * java泛型使用擦除来实现的，这意味着当你在使用泛型的时候，任何具体的类型信息都被擦除了，为一知道的是你在使用一个对象。
 * 因此List<String>和List<Integer>在运行时事实上是相同的类型。这两种形式都被擦除成它的原生类型，即List。
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args){
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1.getSimpleName());
        System.out.println(c2.getSimpleName());
        System.out.println(c1==c2);
    }
}
