package thinkingInJava.August20th;

/**
 * 类中所有private都隐式的指定为final
 * 若试图覆盖一个private方法，编译器不会给出错误信息
 *“覆盖”只有在某方法是基类接口的一部分时才会出现，必须能将一个对象向上转型为它的基本类型并调用相同的方法
 * 若某方法为private，那么他就不是基类接口的一部分。它仅是类中隐藏的程序代码，只不过是具有相同名称而已。
 * 如果在导出类中以相同名称生成一个public，protected或者包访问权限方法的话，你并没有覆盖该方法，仅是生成了一个新方法
 */
public class FinalOverWritingIllusion {
    public static void main(String[] args){
        OverwritingPrivate2 op2 =new OverwritingPrivate2();
        op2.f();
        op2.g();
        OverwritingPrivate op = op2;
        op.f();
        op.g();
        WithFinals wt = op2;
//        wt.f();
//        wt.g();

    }
}
