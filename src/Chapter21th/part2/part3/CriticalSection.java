package Chapter21th.part2.part3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 希望防止多个线程同时访问方法内部的部分代码而不是防止访问整个方法。
 * 通过这种方式分离出来的代码段被称为临界区，他使用synchronized指定某个对象，此对象的锁被用来对花括号内的代码进行同步控制
 */

/**
 * pair不是线程安全的，约束条件需要两个变量要维护成相同的值
 * 自增加操作不是线程安全的，因为方法没有标记为synchronized
 *
 * PairManager类的结构，它的一些功能在基类中实现，并且一个或多个抽象方法在派生类中定义，这种结构在设计模式中称为模板方法
 * 设计模式得以把变化封装在代码里；在这里发生变化的部分是模板方法increment（）。
 */
class Pair{
    private int x,y;
    public Pair(int x,int y){
        this.x =x;
        this.y= y;
    }
    public Pair(){this(0,0);}
    public int getX(){return x;}
    public int getY(){return y;}
    public void incrementX(){x++;}
    public void incrementY(){y++;}
    public String toString(){
        return "x:"+x+", y:"+y;
    }
    public class PairValuesNotEqualException extends RuntimeException{
        public PairValuesNotEqualException(){
            super("Pair values not equal "+Pair.this);
        }
    }
    public void checkState(){//检查pair的状态，x和y的值不等就抛出异常
        if(x!=y){
            throw new PairValuesNotEqualException();
        }
    }
}

/**
 * PairManager类持有一个Pair对象并控制对它的一切访问，。
 * 唯一的public方法时getPair（）是synchronized
 * 对于抽象方法increment（），对increment的同步控制将在实现的时候进行处理
 *
 *  * PairManager类的结构，它的一些功能在基类中实现，并且一个或多个抽象方法在派生类中定义，这种结构在设计模式中称为模板方法
 *  * 设计模式得以把变化封装在代码里；在这里发生变化的部分是模板方法increment（）。
 */
abstract class PairManager{
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();
    private List<Pair> storage= Collections.synchronizedList(new ArrayList<Pair>());
    public synchronized Pair getPair(){
        return new Pair(p.getX(),p.getY());
    }

    /**
     * store方法将一个Pair对象添加到了synchronized ArrayList中，所以这个操作是线程安全的，
     * 所以这个方法不需要防护，可以放置在synchronized语句块外部
     * @param p
     */
    protected void store(Pair p){
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        }catch(InterruptedException ignore){}
    }
    public abstract void increment();
}

/**
 * increment是同步控制的
 * synchronized关键子不属于方法特征签名组成部分，所以可以在覆盖方法的时候加上去
 */
class PairManager1 extends PairManager{
    public synchronized void increment(){
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}

/**
 * increment是使用同步控制块进行同步的
 */
class PairManager2 extends PairManager{
    public void increment(){
        Pair temp;
        synchronized (this){
            p.incrementX();
            p.incrementY();
            temp= getPair();
        }
        store(temp);
    }
}

/**
 * 这个类被创建来测试两种不同类型的PairManager，其方法实在某个任务2中调用increment（）
 */
class PairManiputor implements Runnable{
    private PairManager pm;
    public PairManiputor(PairManager pm){
        this.pm = pm;
    }
    public void run(){
        while(true){
            pm.increment();
        }
    }
    public String toString(){
        return "Pair: "+pm.getPair()+" checkCounter = "+pm.checkCounter.get();
    }
}

/**
 * PairChecker是跟踪可以运行测试的频度
 * 它在每次成功时都会递增checkCounter
 */
class PairChecker implements Runnable{
    private PairManager pm;
    public PairChecker(PairManager pm){
        this.pm = pm;
    }
    public void run(){
        while(true){
            pm.checkCounter.incrementAndGet();//每次
            pm.getPair().checkState();//如果x等于y，则checkCounter一直在递增
        }
    }
}
public class CriticalSection {
    static void testApproches(PairManager pman1,PairManager pman2){
        ExecutorService exec = Executors.newCachedThreadPool();
        PairManiputor
                pm1 = new PairManiputor(pman1),
                pm2 = new PairManiputor(pman2);
        PairChecker
                pcheck1 = new PairChecker(pman1),
                pcheck2 = new PairChecker(pman2);
        exec.execute(pm1);
        exec.execute(pm2);
        exec.execute(pcheck1);
        exec.execute(pcheck2);
        try{
            TimeUnit.MILLISECONDS.sleep(500);
        }catch (InterruptedException e){
            System.out.println("Sleep interrupted");
        }
        System.out.println("pm1: "+pm1+"\npm2: "+pm2);
        System.exit(0);
    }
    public static void main(String[] args){
        PairManager
                pman1=new PairManager1(),
                pman2 = new PairManager2();
        /**
         * 由于后者采用的同步控制块进行同步，所以对象不加锁的时间更长，所以检查频率会更多
         *  这就是宁愿使用同步控制而不是对整个方法进行同步控制的典型原因：使得其他线程能更多的访问（在安全的情况下尽可能的多）
         */
        testApproches(pman1,pman2);
    }
}
