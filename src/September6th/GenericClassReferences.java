package September6th;

public class GenericClassReferences {
    public static void main() {
        Class intClass = int.class;
        /**
         * 通过泛型语法，可以让编译器强制执行额外的类型检查
         */
        Class<Integer> genericIntClass = int.class;
        /**
         * 普通的类引用不会产生警告信息，尽管泛型引用只能赋值为指向其声明的类型
         * 但是普通的类引用可以被重新赋值为指向任何其他的Class对象
         */
        genericIntClass = Integer.class;
        intClass = double.class;
        /**
         * Class<?>优于Class，即便他们是等价的
         * Class<?>的好处是它表示你并非是碰巧或者由于疏忽，而使用了一个非具体的类引用，你就是选择了一个非具体版本。
         */
        Class<?> intClass2 = int.class;
        intClass = double.class;
        /**
         * 创建一个Class引用，它被限定为某种类型，或该类型的子类型
         * 需要用通配符，与extends关键字相结合，创建一个范围。
         */
        /**
         * 向Class引用添加泛型语法的原因仅仅是为了提供编译期类型检查，如果有操作失误，立即就能发现这一点。
         * 如果是使用普通的Class，直到运行时才会发现。
         */
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
    }
}
