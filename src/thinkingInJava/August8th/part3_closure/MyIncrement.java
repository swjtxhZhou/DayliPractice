package thinkingInJava.August8th.part3_closure;

public class MyIncrement {
    public void increment(){
        System.out.println("Other operation");
    }
    static void f(MyIncrement mi){
        mi.increment();
    }
}
