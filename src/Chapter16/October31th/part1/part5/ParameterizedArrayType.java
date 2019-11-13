package Chapter16.October31th.part1.part5;

/**
 * 通常，数组与泛型不能很好地结合。你不能实例化具有参数化类型的数组；
 * Peel<Banana>[] peels = new Peel<Banana>[10]//Illegal
 * 擦除会移除参数类型信息，而数组必须知道他们所持有的确切类型，以强制保证类型安全
 * 但是可以参数化数组本身的类型
 */
public class ParameterizedArrayType {
    public static void main(String[] args){
        Integer[] ints = {1,2,3,4,5};
        Double[] doubles = {1.1,2.2,3.3,4.4,5.5};
        Integer[] ints2 = new ClassParameter<Integer>().f(ints);
        Double[] doubles2 = new ClassParameter<Double>().f(doubles);

        ints2=MethodParameter.f(ints);
        doubles2 = MethodParameter.f(doubles);
    }
}
class ClassParameter<T>{
    public T[] f(T[] arg){
        return arg;
    }
}
class MethodParameter{
    public static <T> T[] f(T[] arg){return arg;}
}
