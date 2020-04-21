package thinkingInJava.part1.part5_innerClasses;

public class TestOuterAccess {
    private int y = 0;
    class inner{
        private int i = 0;
        private void f(){
            System.out.println("you find me");
        }
    }
    public static void main(String[] args){
        TestOuterAccess t = new TestOuterAccess();
       // System.out.println(t.inner.i);
        TestOuterAccess.inner ti = t.new inner();
        System.out.println(ti.i);
    }
}
