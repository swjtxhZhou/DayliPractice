package thinkingInJava.july31th.ConstructPractice;

public class C extends A{
    B b = new B();
    public C(){
        System.out.println("c");
    }

    public static void main(String[] args){
        C c = new C();
    }
}
