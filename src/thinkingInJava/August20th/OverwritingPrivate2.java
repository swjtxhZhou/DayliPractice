package thinkingInJava.August20th;

public class OverwritingPrivate2 extends OverwritingPrivate{
    public final void f(){
        System.out.print("OverwritingPrivate2.f()");
    }
    public void g(){
        System.out.print("OverwritingPrivate2.g()");
    }
}
