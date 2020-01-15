package Chapter21th.part3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 添加了一个被互斥调用的锁，并使用lock（）和unlock（）方法在next（）内部创建临界资源
 * 使用lock对象的惯用法：紧接着对lock（）的调用，必须在finally子句中放置unlock（）。注意return语句必须放置在try模块中，以确保unlock（）不会过早发生，从而将数据暴露给下一个任务
 *
 * Lock对象的优点之一：如果在使用synchronized关键字时，某些事物失败了，那么就会抛出一个异常，但是没有机会去做清理工作，以维护系统处于良好的状态。
 * 有了显式的Lock对象，就可以使用finally语句将系统维护在正确的状态了
 */
public class MutexEvenGenerator extends IntGenerator{
    private int currentValue = 0;
    private Lock lock= new ReentrantLock();
    public int next(){
        lock.lock();
        try{
            ++currentValue;
            Thread.yield();
            ++currentValue;
            return currentValue;
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args){
        EvenChecker.test(new MutexEvenGenerator());
    }
}
