package thinkingInJava.August8th;

public class Implementation2 implements Service{
    /**
     * 私有构造器，表示只能被本类“内部”其他函数调用
     */
    private Implementation2(){}
    public void method1(){
        System.out.println("Implementation2 method1");
    }
    public void method2(){
        System.out.println("Implementation2 method2");
    }
    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation2();
        }
    };
}
