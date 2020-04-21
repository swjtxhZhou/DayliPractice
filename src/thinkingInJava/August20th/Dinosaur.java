package thinkingInJava.August20th;

/**
 * 将某个类整体定义为final时，就表明了你不打算继承该类，而且也不允许别人这么做
 */
final class Dinosaur {
    /**
     * final类的域可以根据个人意愿选择是不是final
     * final类中的方法都被隐式的指定为final
     */
    int i = 7;
    int j = 1;
    SmallBrain x=new SmallBrain();
    void f(){}
}
