package thinkingInJava.October10th.InstantiateType.FactoryConstraint;

public class IntegerFactory implements FactoryI<Integer> {
    public Integer create(){
        return new Integer(0);
    }
}
