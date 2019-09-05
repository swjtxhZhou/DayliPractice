package September5th.Rtti.ClassInitialization;

import java.util.Random;

/**
 * 当使用“。class”来创建对象的引用时，不会自动地初始化该Class对象。为了使用类而做的准备工作实际包含三个部分
 * 1.加载，这是由类加载器执行的。该步骤将查找字节码（通常在classpath所指定的路劲中查找，但这并非时必须的），并从这些字节码中创建一个Class对象。
 * 2.链接，在链接阶段将验证类中的字节码，为静态域分配存储空间，并且如果必须的话，将解析这个类创建的对其它类的所有引用
 * 3.初始化，如果该类有超类，则对其初始化，执行静态初始化器和静态初始化块
 * 初始化被延迟到了对静态方法（构造器隐式地是静态的）或者非常数静态域进行首次引用时才执行。
 */
public class ClassInitialization {
    public static Random rand = new Random(47);
    public static void main(String[] args)throws Exception{
        /**
         * 仅使用。class语法来获得对类的引用不会引发初始化。但是为了产生class引用，Class.forName()立即就进行了初始化，就像对initable3引用的创建多看到的
         */
        Class initable = Initable.class;
        System.out.println("after creating Initable ref");
        /**
         * 如果一个static final 值是“编译器常量”，就像Initable。staticFinal那样，那么这个值不需要对Initable类进行初始化就可以被读取。但是，如果只是将一个域设置为static和final的，还不足其确保这个行为，
         * 例如，对Initable.staticFinal2的访问将强制进行类的初始化，因为他不是一个编译器常量。
         */
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);
        /**
         * 如果一个static域不是final的，那么在对它访问时，总要求在他被读取之前
         * 要先进行链接（为这个域分配存储空间）和初始化（初始化该存储空间）
         */
        System.out.println(Initable2.staticNonFinal);
        Class initable3=Class.forName("September5th.Rtti.ClassInitialization.Initable3");
        System.out.println("after creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}
