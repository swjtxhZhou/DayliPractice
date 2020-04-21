package thinkingInJava.Chapter21th.part6th.deadLock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import static Utils.StringUtils.*;

public class Philosopher implements Runnable{
    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFactor;
    private Random rand = new Random(47);
    private void pause()throws InterruptedException{
        if(ponderFactor == 0){return;}
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor*250));
    }
    public Philosopher(Chopstick left,Chopstick right,int idn,int ponder){
        this.left = left;
        this.right = right;
        id = idn;
        ponderFactor = ponder;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                println(this+" thinking");
                pause();
                println(this+" grabbing right");
                right.take();
                println(this+" grabbing left");
                left.take();
                println(this+" eating");
                pause();
                right.drop();
                left.drop();
            }
        }catch(InterruptedException e){
            println(this+" exiting via interrupted");
        }
    }
    public String toString(){
        return "Philosopher "+id;
    }
}
