package thinkingInJava.part1.part6;

import java.util.Random;

public class Enums {
    private static Random rand = new Random(47);

    /**
     * <T extends Enum<T>>表示T是一个enum实例，将Class<T>作为参数的话，我们就可以利用Class对象得到enum实例的数组了
     * @param ec
     * @param <T>
     * @return
     */
    public static <T extends Enum<T>> T random(Class<T> ec){
        return random(ec.getEnumConstants());
    }

    /**
     * 重载后的random（）方法只需使用T[]作为参数，因为他并不会调用Enum上的任何操作，只需从数组中选择一个元素即可。这样最终返回的类型就是enum的类型
     * @param values
     * @param <T>
     * @return
     */
    public static <T> T random(T[] values){
        return values[rand.nextInt(values.length)];
    }
}
