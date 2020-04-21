package thinkingInJava.String;

/**
 * String对象是不可变的。String类每一个看起来会修改String值的方法
 * 实际上都是创建一个全新的String对象，而最初的String对象丝毫未动
 */
public class Immutable {
    public static String upCase(String s){
        return s.toUpperCase();
    }
    public static void main(String[] args){
        String p = "everything fine";
        System.out.println(p);
        String pp = upCase(p);
        System.out.println(pp);
        System.out.println(p)  ;
    }
}
