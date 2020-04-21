package thinkingInJava.Chapter21th.part6th.deadLock;

/**
 * 任何两个哲学家都不能成功take（）同一根筷子。若一根已经被占用，另一个可以await（）直到当前持有者drop（）使其可用为止。
 */
public class Chopstick {
    private boolean taken = false;
    public synchronized  void take()throws InterruptedException{
        while(taken){
            wait();
        }
        taken = true;
    }
    public synchronized void drop(){
        taken = false;
        notifyAll();
    }
}

