package thinkingInJava.August8th.part3_closure;

public class Callbacks {
    public static void main(String[] args){
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        /**
         * Callee2继承了MyIncrement
         */
        MyIncrement.f(c2);
        /**
         * Caller接受实现了Incrementable接口的对象
         * c1直接扩展了Incrementable接口，所以可以直接作为构造器参数
         * c2只有内部类扩展了这个接口，该内部类能访问外部类的所有元素，通过回调方式可以携带外部类的信息给出来
         */
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
