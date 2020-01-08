package Chapter21th.part2.part4;
import static Utils.StringUtils.*;

/**
 * 若尝试在一个对象上调用其synchronized方法，而这个对象地锁已经被其他任务获得，那么调用任务将被挂起（阻塞），直至这个可锁获得。下面示例说明了同一个互斥可以如何能被同一个任务多次获得
 */
public class MutiLock {
    /**
     * 由于这个任务已经在第一个对f1（）地调用中获得了multiLock对象锁，因此同一份任务将在对f2（）的调用中再次获得这个锁，一次类推，
     * 因为一个任务应该能够调用在同一个对象中的其他synchronized方法，而这个任务已经持有锁了。
     * @param count
     */
    public synchronized void f1(int count){
        if(count-- >0){
            println("f1() calling f2() whit count "+count);
            f2(count);
        }
    }
    public synchronized void f2(int count){
        if(count-- >0){
            println("f2() calling f1() whit count "+count);
            f1(count);
        }
    }
    public static void main(String[] args)throws Exception{
        final MutiLock mutiLock = new MutiLock();
        new Thread(){
            public void run(){
                mutiLock.f1(10);
            }
        }.start();
    }
}
