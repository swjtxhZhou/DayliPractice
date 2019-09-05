package September5th.Rtti.ClassInitialization;

public class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
    static{
        System.out.println("Initializing Initable");
    }
}
