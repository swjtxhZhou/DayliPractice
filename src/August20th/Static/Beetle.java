package August20th.Static;

/**
 * 在Beetle上运行java，
 * 第一件事就是试图访问Beetle.main()-static方法，于是加载器开始启动并找出Beetle类的编译代码（在Beetle。class中）
 * 对它进行加载的过程中，编译器注意它有一个基类（由关键子extends得知），于是它继续进行加载。不管是否会产生基类对象它都会加载
 * 若该基类还有其自身的基类，则第二个基类就会被加载。接下来，根基类的初始化就会被执行，然后式下一个导出类。采取这样的方式，因为导出类的static初始化可能会依赖基类成员能否被正确初始化。
 *
 */

/**
 * 到此为止，所有类都被加载完了，对象就可以被创建了。首先对象中所有的基本类型都会被设置为默认值，对象引用被设置为null-通过将对象设置为二进制零值而一举生成的。
 * 然后基类构造器会被调用。在本列中它是自动被调用的，也可以用super来指定对基类构造器的调用。基类构造器和导出类构造器一样以相同顺序来经历相同的过程。
 * 在基类构造器完成之后，实列变量按其次序被初始化。最后构造器的其余部分被执行。
 */
public class Beetle extends Insect{
    private int k = printInit("Beetle.k initialized");
    public Beetle(){
        System.out.print(" k= "+k);
        System.out.print(" j= "+j);
    }
    private static  int x2 = printInit("static Beetle.x2 initialized");
    public static void main(String[] args){
        System.out.println("Beetle constructor");
        Beetle b = new Beetle();
    }
}
