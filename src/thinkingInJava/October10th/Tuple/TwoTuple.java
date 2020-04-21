package thinkingInJava.October10th.Tuple;

public class TwoTuple<A,B> {
    /**
     * 没有getFirst（）这样的方法，其属性为public
     * final声明买了相同的安全保险，而且这种格式更简洁明了
     */
    public final A first;
    public final B second;
    public TwoTuple(A a,B b){
        first = a;
        second = b;
    }
    public String toString(){
        return "("+first +","+second+")";
    }
}
