package thinkingInJava.August8th.part3_closure;

public class Callee2 extends MyIncrement{
    private int i = 0;
    public void increment(){
        super.increment();
        i++;
        System.out.println(i);
    }

    /**
     * 闭包是一个可调用的对象，它记录了一些信息，这些信息来自与创建他的作用域
     * 通过内部类提供闭包的功能
     */
    private class Closure implements Incrementable{
        public void increment(){
            Callee2.this.increment();
        }
    }
    Incrementable getCallbackReference(){
        return new Closure();
    }
}
