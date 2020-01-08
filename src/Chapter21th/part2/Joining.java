package Chapter21th.part2;

class Sleeper extends Thread{
    private int duration;
    public Sleeper(String name, int sleepTime){
        super(name);
        duration= sleepTime;
        start();
    }
    public void run(){
        try{
            sleep(duration);
        }catch(InterruptedException e){
            System.out.println(getName()+" was interrupted."+" IsInterrupted() "+isInterrupted());
            return;
        }
        System.out.println(getName()+" has wakened");
    }
}

class Joiner extends Thread{
    private Sleeper sleeper;
    public Joiner(String name, Sleeper sleeper){
        super(name);
        this.sleeper=sleeper;
        start();
    }
    public void run(){
        try{
            /**
             * 如果某个线程在另一个线程t上调用t.join(),此线程将被挂起，直到线程结束才恢复（即以t.isAlive()返回为false）
             * Jioner线程将通过在Sleeper对象上调用join（）方法来等待Sleeper醒来
             */
            sleeper.join();
        }catch(InterruptedException e){
            System.out.println("Interrupted!");
        }
        System.out.println(getName()+" join completed");
    }
}

public class Joining {
    public static void main(String[] args){
        Sleeper sleepy =  new Sleeper("Sleepy",1500),grumpy = new Sleeper("Grumpy",1500);
        Joiner dopey= new Joiner("Dppey",sleepy);
        Joiner doc = new Joiner("Doc",grumpy);
        /**
         * 对join（）方法的调用可以被中断，做法是在调用线程上调用interrupt（）方法，这是需要try-catch语句
         */
        grumpy.interrupt();
    }
}
