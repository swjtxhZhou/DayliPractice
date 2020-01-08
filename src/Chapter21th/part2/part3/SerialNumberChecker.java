package Chapter21th.part2.part3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CircuSet重用了存储int数值的内存，并假设在你生成序列数时，产生数值覆盖率冲突的可能性很小
 */
class CircularSet{
    private int[] array;
    private int len;
    private int index = 0;
    public CircularSet(int size){
        array = new int[size];
        len = size;
        for(int i=0;i<size;i++){
            array[i]=-1;
        }
    }
    public synchronized void add(int i){
        array[index] = i;
        index = ++index %len;
    }
    public synchronized boolean contains(int val){
        for(int i=0;i<len;i++){
            if(array[i]==val) return true;
        }
        return false;
    }
}

public class SerialNumberChecker {
    private static final int SIZE = 10;
    /**
     * 持有所产生的所有序列数
     */
    private static CircularSet serials = new CircularSet(1000);
    private static ExecutorService exec = Executors.newCachedThreadPool();

    /**
     * SerialChecker可以确保序列数是唯一的
     */
    static class SerialChecker implements Runnable{
        public void run(){
            while(true){
                /**
                 * 当在nextSerialNumber前添加synchronized，可以解决出现重复的问腿
                 * 对基本类型的读取和赋值操作被认为是安全的原子性操作。但是，当对象处于不稳定状态时，仍旧很有可能使用原子性操作来访问他们
                 */
                int serial = SerialNumberGenerator.nextSerialNumber();
                if(serials.contains(serial)){
                    System.out.println("Duplicate: "+serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }
    public static void main(String[] args)throws Exception{
        for(int i=0;i < SIZE;i++){
            exec.execute(new SerialChecker());
        }
        if(args.length>0){
//            System.out.println(args.length);
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
            System.out.println("no duplicates detected");
            System.exit(0);
        }
    }
}
