package thinkingInJava.August26th;

public class NeverCaught {
    static void f(){
        /**
         * RuntimeException,编译器不需要异常说明，其输出报告给了System.err
         * 若RuntimeException没有被捕获而直达main（），那么在程序退出前将调用异常的printStackTrace()方法。
         * 究其原因，RuntimeException代表的是编程错误。
         */
        throw new RuntimeException();
    }
    public static void main(String[] args){
        f();
    }
}
