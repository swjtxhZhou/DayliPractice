package October10th.InstantiateType.FactoryConstraint;

public class FactoryConstraint {
    public static void main(String[] args){
        new Foo2<Integer>(new IntegerFactory());
        new Foo2<Widget>(new Widget.Factory());
    }
}
