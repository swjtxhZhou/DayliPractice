package thinkingInJava.August8th;

public class Implementation1 implements Service{
    /**
     * 私有构造器，表示只能被本类“内部”其他函数调用
     */
    private Implementation1(){}
    public void method1(){
        System.out.println("Implementation1 method1");
    }
    public void method2(){
        System.out.println("Implementation1 method2");
    }

    /**
     * 使用匿名内部类
     */
    public static ServiceFactory factory= new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation1();
        }
    };
}
