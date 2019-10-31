package October10th.InstantiateType.FactoryConstraint;

import September6th.Factory.Factory;

public class IntegerFactory implements FactoryI<Integer> {
    public Integer create(){
        return new Integer(0);
    }
}
