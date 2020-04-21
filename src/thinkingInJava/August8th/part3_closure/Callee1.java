package thinkingInJava.August8th.part3_closure;

public class Callee1 implements Incrementable{
    private int i=0;
    public void increment(){
        i++;
        System.out.println(i);
    }
}
