package thinkingInJava.Chapter21th.part2;

import java.util.concurrent.ThreadFactory;

/**
 * 通过编写定制的ThreadFactory可以定制由Executor创建的线程的属性（后台，优先级，名称）
 * 这与普通的ThreadFactory的唯一差异就是它将后台状态全部设置为了true
 * 可以用一个新的DaemonThreadFactory作为参数传递给Executors.newCachedThreadPool();
 */
public class DaemonThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r){
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
