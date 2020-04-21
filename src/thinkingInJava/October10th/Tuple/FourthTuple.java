package thinkingInJava.October10th.Tuple;

public class FourthTuple<A,B,C,D> extends ThreeTuple<A,B,C> {
    public final D fourth;
    public FourthTuple(A a,B b,C c,D d){
        super(a,b,c);
        fourth = d;
    }
    public String toString(){
        return "("+first+", "+second+", "+third+", "+fourth+")";
    }
}
