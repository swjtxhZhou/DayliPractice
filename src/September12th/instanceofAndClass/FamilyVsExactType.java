package September12th.instanceofAndClass;

public class FamilyVsExactType {
    static void test(Object x){
        /**
         * instanceof 和 isInstanceof 会向上检查类型
         * == 和 equals 不会向上检查类型
         */
        System.out.println("Testing x of type:"+x.getClass());
        System.out.println("x instanceof Base:"+(x instanceof Base));
        System.out.println("x instanceof Derived:"+(x instanceof Derived));
        System.out.println("Base.isInstanceof(x):"+Base.class.isInstance(x));
        System.out.println("Derived.isInstanceod(x):"+Derived.class.isInstance(x));
        System.out.println("x.getClass()==Base.class:"+(x.getClass()==Base.class));
        System.out.println("x.getClass()==Derived.class:"+(x.getClass()==Derived.class));
        System.out.println("x.getClass().equals(Base.class):"+(x.getClass().equals(Base.class)));
        System.out.println("x.getClass().equals(Derived.class):"+(x.getClass().equals(Derived.class)));
    }
    public static void main(String[] args){
        test(new Base());
        test(new Derived());
    }
}
