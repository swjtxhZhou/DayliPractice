package thinkingInJava.Chapter21th.part2;

import java.util.concurrent.TimeUnit;

class Daemon implements Runnable{
    private Thread[] t = new Thread[10];
    public void run(){
        for(int i=0;i<t.length;i++){
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn "+i+" started.");
        }
        for(int i=0;i<t.length;i++){
            System.out.println("t["+i+"].isDaemon()="+t[i].isDaemon()+", ");
        }
        while(true){
            Thread.yield();
        }
    }
}
class DaemonSpawn implements Runnable{
    public void run(){
        while(true){
            Thread.yield();
        }
    }
}
public class Daemons {
    public static void main(String[] args)throws Exception{
        Thread d = new Thread(new Daemon());
        /**
         * Daemon线程被设置成了后台模式，然后派生出许多子线程，这些线程并没有被显示地设置为后台模式
         * 不过他们的确是后台进程。接着，Daemon线程进入了无限循环，并在循环里调用yield（）方法把控制权交给其他进程
         */
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon()= "+d.isDaemon()+", ");
        TimeUnit.SECONDS.sleep(1);
    }
}
