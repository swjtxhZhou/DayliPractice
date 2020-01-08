package Chapter21th.part2.part3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ExplicitPairManage1 extends PairManager{
    private Lock lock = new ReentrantLock();
    public synchronized void increment(){
        lock.lock();
        try{
            p.incrementX();
            p.incrementY();
            store(getPair());
        }finally {
            lock.unlock();
        }
    }
}
class ExplicitPairManage2 extends PairManager{
    private Lock lock = new ReentrantLock();
    public synchronized void increment(){
        Pair temp;
        lock.lock();
         try{
             p.incrementX();
             p.incrementY();
             temp=getPair();
         }finally {
             lock.unlock();
         }
         store(temp);
    }
}
public class ExplicitCriticalSection {
    public static void main(String[] args){
        PairManager
                pm1 = new ExplicitPairManage1(),
                pm2 = new ExplicitPairManage2();
        CriticalSection.testApproches(pm1,pm2);
    }
}
