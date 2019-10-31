package September25th;

import java.lang.reflect.Proxy;

public class SimpleDynamicProxy {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("bonbon");
    }
    public static void main(String[] args){
        RealObject real = new RealObject();
        consumer(real);
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),new Class[]{Interface.class},new DynamicProxyHandler(real));//一个类加载器，一个希望代理实现的接口列表（不是类或者是抽象类），以及InvocationHandler接口的一个实现
        consumer(proxy);
    }
}
