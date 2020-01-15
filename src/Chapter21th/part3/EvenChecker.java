package Chapter21th.part3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * EvenChecker任务总是读取和测试从与其相关的IntGenerator放回的值。
 * 注意，如果generator。isCanceled（）为true，则run（）将返回，这将告知EvenChecker（）中的Executor该任务完成了。
 * 任何EvenChecker任务都可以在与其相关联的IntGenerator上调用cancel（），这将导致所有其他使用该IntGenerator的EvenChecker得体的关闭
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;
    public EvenChecker(IntGenerator g,int ident){
        generator = g;
        id = ident;
    }

    /**
     * 所有依赖于IntGenerator对象的EvenChecker任务将测试它，以查看它是否被撤销。
     * 通过这种方式，共享公共资源的任务可以观察该资源的终止信号
     */
    public void run(){
        while(!generator.isCanceled()){
             int val = generator.next();
             if(val%2 != 0 ){
                 System.out.println(val+" not even!");
                 generator.cancel();
             }
        }
    }

    /**
     * 该方法通过启动大量使用相同的IntGenerator的EvenChecker，设置并执行对任何类型的IntGenerator的测试。如果IntGenerator引发失败，那么test（）将报告它并返回，否则必须按下control-c来终止它
     * @param g
     * @param count
     */
    public static void test(IntGenerator g,int count){
        System.out.println("press contrl-c to exit!");
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i =0; i<count;i++){
            exec.execute(new EvenChecker(g,i));
        }
        exec.shutdown();
    }
    public static void test(IntGenerator g){
        test(g,10);
    }
}
