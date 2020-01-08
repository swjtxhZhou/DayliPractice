package Chapter21th.part2;

/**
 * 从Runnable导出的类，必须具有run（）方法，但是这个方法并无特殊之处--他不会产生内在的线程能力
 * 要实现线程行为，必须显示地将一个任务附着到线程上
 */
public class LiftOff implements Runnable{
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;//用来区分任务的实例，因为是final的，一旦被初始化之后就不希望被修改
    public LiftOff(){}
    public LiftOff(int countDown){
        this.countDown = countDown;
    }
    public String status(){
        return "#"+id+"("+(countDown>0?countDown:"LiftOff!")+"), ";
    }

    /**
     * 任务的run（）方法通常总会有某种形式的循环，使得任务一直运行下去直到不再需要。所以要设定跳出循环的条件（）
     * 通常。run（）被写成无限循环的形式，除非有某个条件使得run（）终止，否则将永远运行下去
     */

    public void run(){
        while(countDown-- > 0){
            System.out.println(status());
            /**
             * 这个方法是对线程调度器的一种建议（java线程机制的一部分，可以将cpu从一个线程转移给另一个线程）
             * 它在声明，“我已经执行完生命周期中最重要的部分，此刻正是切换给其他任务执行一段时间的大好时机”
             */
            Thread.yield();
        }
    }
}
