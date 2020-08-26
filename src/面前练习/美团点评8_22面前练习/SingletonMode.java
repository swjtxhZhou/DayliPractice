package 面前练习.美团点评8_22面前练习;

import java.util.Collections;

public class SingletonMode {
    //单例模式
    private SingletonMode(){}

    /**
     * 饿汉模式，(线程安全的，不管用不用先创建了再说，典型的空间换时间)
     *全局的单例模式在类装载的时候就创建好了
     */
//    private static SingletonMode singletonMode = new SingletonMode();
//    public SingletonMode getSingletonMode_notHungry(){
//        return singletonMode;
//    }
    /**
     * 懒汉模式
     * 全局的单例实例在第一次使用时创建
     */
    //非线程安全版本
//    private  static SingletonMode singletonMode;
//
//    public SingletonMode getSingletonMode_hungry(){
//        if(singletonMode==null){
//            singletonMode = new SingletonMode();
//
//        }
//        return singletonMode;
//    }
    //synchronized线程安全版本,直接使用synchronized的话，每次进行获取单例都要进行加锁，增加了时间消费还有可能发生阻塞
//    private static SingletonMode singletonMode;
//    public synchronized SingletonMode getSingletonMode_hungry(){
//        if(singletonMode==null){
//            singletonMode = new SingletonMode();
//        }
//        return singletonMode;
//    }

    //懒汉模式-双重检查加锁版本(DCL)，可以大大减少获取单例的时间消耗
    /**
     * volatile关键字的作用
     * happen-before规则：对volatile字段的写操作happen-before后续对对一个字段的读操作
     * 需要保证对singletonMode的访问是读在写之后，正确的做法是在singletonMode加上volatile关键字
     * 如果没有volatile，线程a获取了类对象的锁，开始初始化，初始化的过程是很多指令，此时一个线程B访问到了singletonMode==null，此时线程A可能只对部分的属性进行了赋值
     * 这个时候B线程读到的singletonMode可能就不是null，就会造成数据丢失的现象。
     * volatile保证了singletonMode先写完再读。避免上面的情况发生。
      */
//    private volatile static SingletonMode singletonMode;//使用volatile保证了数据的可见性，不能保证线程安全
//    public SingletonMode getSingletonMode_doubleCheck(){
//        if(singletonMode==null){
//            synchronized (SingletonMode.class){//锁住这个类而不是这个对象
//                //进入同步代码块在检查一次，为null
//                if(singletonMode==null){
//                    singletonMode = new SingletonMode();
//                }
//                return singletonMode;
//            }
//        }
//        return singletonMode;
//    }
    //静态内部类方式(懒汉方式)

    /**
     * 静态内部类的优点是：外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，故而不占内存。
     * 即当SingleTon第一次被加载时，并不需要去加载SingleTonHoler，只有当getInstance()方法第一次被调用时，才会去初始化INSTANCE,
     * 第一次调用getInstance()方法会导致虚拟机加载SingleTonHoler类，这种方法不仅能确保线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化。
     * Java虚拟机有且仅有在五种场景下会对类进行初始化：
     * 1、new一个关键字或者实例对象时、读取或者设置一个静态字段时、调用一个类的静态方法时
     * 2、使用reflect反射调用时
     * 3、初始化一个类，其父类还没有初始化
     * 4、虚拟机启动时，需要一个主类
     * 5、动态语言
     * 当getInstance()方法被调用时，SingleTonHoler才在SingleTon的运行时常量池里，把符号引用替换为直接引用，
     * 这时静态对象INSTANCE也真正被创建，然后再被getInstance()方法返回出去
     * 虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确地加锁、同步，如果多个线程同时去初始化一个类，那么只会有一个线程去执行这个类的<clinit>()方法，
     * 其他线程都需要阻塞等待，直到活动线程执行<clinit>()方法完毕。
     */
    private static class SingletonHolder{
        private static final SingletonMode singletonMode = new SingletonMode();
    }
    public static final SingletonMode getInstance(){
        return SingletonHolder.singletonMode;
    }

}
