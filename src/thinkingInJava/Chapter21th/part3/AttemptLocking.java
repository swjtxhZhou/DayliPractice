package thinkingInJava.Chapter21th.part3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking implements Runnable{
    /**
     * 允许你尝试着获取但最终未获取锁，这样如果其他人已经获取了这个锁，那你就可以决定离开取执行其他一些事情，而不是等待这个锁被释放
     * 显式的lock对象在加锁和释放锁方面，相对于内建的synchronized锁来说，还赋予了你更细腻度的控制力。
     * 这对于内建的synchronized锁来说，还赋予你更细腻度的控制力。这对于实现专有同步结构是很有用的，列如用于遍历链接列表中的节点的节节传递的加锁机制（锁耦合），
     * 这种遍历代码必须在释放当前节点的锁之前捕获下一个节点的锁
     */
    private ReentrantLock lock = new ReentrantLock();
    public void untimed(){
        boolean captured = lock.tryLock();
        try{
            System.out.println("tryLock() : "+captured);
        }finally{
            if(captured){
                lock.unlock();
            }
        }
    }
    public void timed(){
        boolean captured = false;
        try{
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        try{
            System.out.println("trylock(2,TimeUnit.SECONDS) : "+captured);
        }finally{
            if(captured){
                lock.unlock();
            }
        }
    }
    public void run(){
        lock.lock();
        System.out.println("acquired");
    }
    public static void main(String[] args) {
        try {
            AttemptLocking al = new AttemptLocking();
            al.untimed();
            al.timed();
            Thread t = new Thread(al);
            t.start();
//        new Thread(){
//            {setDaemon(true);}
//            public void run(){
//                al.lock.lock();
//                System.out.println("acquired");
//            }
//        }.start();
            Thread.yield();
            TimeUnit.MILLISECONDS.sleep(100);
            al.untimed();
            al.timed();
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
