package October10th.InstantiateType.FactoryConstraint;

public class Widget {
    public static class Factory implements FactoryI<Widget>{
        public Widget create(){
            return new Widget();
        }
    }
}
