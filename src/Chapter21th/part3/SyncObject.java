package Chapter21th.part3;

/**
 * synchronized块必需给定一个在其上进行同步的对象，合理的方式是使用其方法正在被调用的当前对象：synchronized（this）
 * 这种方式如果获得了synchronized块上的锁，那么该对象其他的synchronized方法和临界区就不能被调用
 * 这里演示了，两个任务同时进入到同一个对象，只要这个对象上的方法实在不同的锁上同步的即可
 */
class DualSynch{
    private Object syncObject = new Object();
    public synchronized void f(){
        for(int i= 0;i<5;i++){
            System.out.println("f()");
            Thread.yield();
        }
    }

    /**
     * g()是在synObject上同步的synchronized块，f()是在this同步
     * 所以这两个同步是相互独立的
     */
    public void go(){
        synchronized (syncObject){
            for(int i=0; i<5;i++){
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}
public class SyncObject {
    public static void main(String[] args){
        final DualSynch ds = new DualSynch();
        new Thread(){
            public void run(){
                ds.f();
            }
        }.start();
        ds.go();
    }
}
