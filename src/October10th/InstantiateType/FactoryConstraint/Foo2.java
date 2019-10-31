package October10th.InstantiateType.FactoryConstraint;

import September6th.Factory.Factory;

public class Foo2<T> {
    private T x;
    public <F extends FactoryI<T>> Foo2(F factory){
        x = factory.create();
    }
}
