package Chapter21th.part2;

public class BasicThread {
    public static void main(String[] args){
        /**
         * Thread构造器只需要一个Runnable对象，调用Thread对象的start方法为该线程执行必须的初始化操作，然后调用run（）方法，以便在这个新线程中启动该任务
         * main()和LiftOff。run（）是程序中与其他线程“同时”执行的代码
         */
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("waiting for LiftOff!");
    }
}
