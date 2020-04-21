package thinkingInJava.part1.part5_innerClasses;

public class DotThis {
    void f() {
        System.out.println("DotThis.f()");
    }
    public class Inner{
        public DotThis outer(){
            /**
             * 生成对外部类对象的引用，可以使用外部类的名字后面紧跟圆点和this。这样产生的引用自动地具有正确的类型
             */
            return DotThis.this;
        }
    }
    public Inner inner(){
        return new Inner();
    }
    public static void main(String[] args){
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}
