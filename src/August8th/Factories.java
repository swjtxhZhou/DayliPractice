package August8th;

public class Factories {
    public static void serviceConsumer(ServiceFactory fact){
        Service s=fact.getService();
        s.method1();
        s.method2();
    }
    public static void main(String[] args){
        /**
         * factory被声明为静态变量
         */
        serviceConsumer(Implementation1.factory);
        serviceConsumer(Implementation2.factory);
    }

}
