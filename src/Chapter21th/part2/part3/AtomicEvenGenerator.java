package Chapter21th.part2.part3;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicEvenGenerator extends IntGenerator{
    /**
     * 被多个线程访问的属性没有添加volatile
     * next（）方法也没有添加synchronized
     * 程序不会停止运行
     * 特殊的原子性变量类，拥有机器级别上的原子性，在使用它们时，通常不需要担心。对于常规编程，它们很少派上用场，但是在涉及性能调优时，就有用武之地了。
     * Atomic类被设计用来构建util。concurrent中的类，因此只有在特殊情况下在自己的代码中使用。通常依赖于锁要更安全一些（synchronized或者lock（））
     */
    private AtomicInteger currentEvenValue = new AtomicInteger(0);
    public int next(){
        return currentEvenValue.addAndGet(2);
    }
    public static void main(String[] args){
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
