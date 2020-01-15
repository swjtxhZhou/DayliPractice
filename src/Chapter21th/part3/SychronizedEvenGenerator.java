package Chapter21th.part3;

public class SychronizedEvenGenerator extends IntGenerator{
    private int currentEvenValue = 0;

    /**
     * 第一个进入next（）的任务将获得锁，任何其他试图获得锁的任务都将从其开始尝试之时被阻塞，直至第一个任务释放锁
     * @return
     */
    public synchronized int next(){
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }
    public static void main(String[] args){
        EvenChecker.test(new SychronizedEvenGenerator());
    }
}
