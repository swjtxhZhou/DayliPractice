package Chapter21th.part3;

public class SerialNumberGenerator {
    private static volatile int serialNumber=0;
    public synchronized static int nextSerialNumber(){
        /**
         * java递增操作不是原子性的，并且涉及一个读操作和一个写操作。这为产生线程问题留下了空间
         * 真正的问题在于nextSerialNumber（）在没有同步的情况下对共享可变值进行了访问
         * 若一个域可能会被多个任务同时访问，并且这多个任务至少有一个是写入任务，那么你就应该将这个域设置未volatile的。
         * 若将一个域定义为volatile，那么他就会告诉编译器不要执行-任何移除读取喝写入操作-的优化
         * 但是volatile并不能对递增是原子性操作这一事实产生影响
         */
        return serialNumber++;
    }
}
