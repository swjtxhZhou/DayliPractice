package thinkingInJava.Chapter21th.part4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 单个的Count对象来跟踪花园参观者的主计数值，并且将其当作Entrance类中的一个静态域进行存储。
 * value和increment都是synchronized的，用来控制对count域的访问
 */
class Count{
    private int count = 0;
    private Random rand = new Random(47);

    /**
     * increment()方法使用了Random对象，目的是从把count读取到temp中，到递增temp并将其存储回count，这段时间有大约一半都在通知其他线程来运行
     * 若将increment（）上的synchronized注释掉，这个程序就会崩溃
     * temp和yield（）增加了失败的可能性。
     * @return
     */
    public synchronized int increment(){
        int temp = count;
        if(rand.nextBoolean())Thread.yield();
        return (count = ++temp);
    }
    public synchronized int value(){return count;}
}
class Entrance implements Runnable{
    private static Count count = new Count();
    private static List<Entrance> entrances=new ArrayList<>();
    /**
     * number是通过某个特定入口进入的参观者的数量，这提供了对count对象的双重检查，以确保其记录的参观者数量是正确的
     */
    private int number = 0;
    private int id;
    /**
     *  这是一个volatile布尔标志，而他只会被读取和赋值（不会与其他域组合在一起被读取），所以不需要同步对其的访问，就可以安全地操作它
     */
    private static volatile boolean canceled = false;
    public static void cancel(){//设置静态的原因是，可以在其他类中来方便操作
        canceled = true;
    }
    public Entrance(int id){
        this.id = id;
        entrances.add(this);
    }

    /**
     * 递增number和count对象，然后休眠100毫秒
     */
    public void run(){
        while(!canceled){
            synchronized (this){
                ++number;
            }
            System.out.println(this+" Total : "+count.increment());
            try{
                TimeUnit.MILLISECONDS.sleep(100);
            }catch(InterruptedException e){
                System.out.println("sleep interrupted!~");
            }
        }
        System.out.println("Stopping "+this);
    }
    public synchronized int getValue(){
        return number;
    }
    public String toString(){
        return "Entrance "+id+": "+getValue();
    }
    public static int getTotalCount(){//为什么是静态的？？？、·
        return count.value();
    }
    public static int sumEntrances(){
        int sum = 0;
        for(Entrance entrance:entrances){
            sum+=entrance.getValue();//不直接使用number，number一直在自增
        }
        return sum;
    }
}
public class OrnamentalGarden {
    public static void main(String[] args)throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i= 0;i<5;i++){
            exec.execute(new Entrance(i));//有五扇旋转门
        }
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        System.out.println("commit cancel");
        exec.shutdown();
        /**
         * awaitTermination()等待每个任务结束，如果所在的任务在超时时间达到之前全部结束，则放回true，否则返回false，表示不是所有的任务结束了。
         */
        if(!exec.awaitTermination(250,TimeUnit.MILLISECONDS)){
            System.out.println("Some task were not terminated!");
        }
        System.out.println("Total: "+Entrance.getTotalCount());
        System.out.println("Sum of Entrance : "+Entrance.sumEntrances());
    }
}
