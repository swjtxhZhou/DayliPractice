package thinkingInJava.Chapter21th.part7th;

import thinkingInJava.October10th.BasicGenerator;
import thinkingInJava.October9th.Generator.Generator;

import java.util.List;
import java.util.concurrent.*;

/**
 * Exchanger是在两个任务之间交换对象的栅栏，当这些任务进入栅栏时，他们各自拥有一个对象，当他们离开时，他们都拥有之前由对象持有的对象。应用场景为：一个任务在创建对象，这些对象的生产代价很高昂，而另一个任务在消费这些对象。通过这种方式可以由更多的对象在被创建期间被消费。
 * @param <T>
 */
class ExchangerProducer<T> implements Runnable{
    private Generator<T> generator;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    ExchangerProducer(Exchanger<List<T>> exg,Generator gen,List<T> holder){
        generator = gen;
        exchanger = exg;
        this.holder = holder;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                for(int i=0; i<ExchangerDemo.size;i++){
                    holder.add(generator.next());
                }
                holder = exchanger.exchange(holder);
            }
        }catch(InterruptedException e){

        }
    }
}
class ExchangerConsumer<T> implements Runnable{
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value;
    ExchangerConsumer(Exchanger<List<T>> ex, List<T> holder){
        exchanger = ex;
        this.holder = holder;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                /**
                 * consumer，通过exchange获取了对象之后，通过使用或消费后要把它从自己的对象列表中移除，防止它又交换回producer。
                 */
                holder = exchanger.exchange(holder);
                for(T x:holder){
                    value = x;
                    holder.remove(x);
                }
            }
        }catch(InterruptedException e){

        }
        System.out.println("Final value: "+value);
    }
}
public class ExchangerDemo {
    static int size = 10;
    static int delay = 5;
    public static void main(String[] args)throws Exception{
        if(args.length >0){
            size = new Integer(args[0]);
        }
        if(args.length>1){
            delay = new Integer(args[1]);
        }
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> xc = new Exchanger<>();
        /**
         * CopyOnWriteArrayList这个特定List的变体允许在列表被遍历时调用remove（）方法，而不会抛出ConcurrentModificationException异常，ExchangeProducer将填充这个List，然后这个满列表交换为ExchangerConsumer传递给它的空列表
         */
        List<Fat>
                producerList = new CopyOnWriteArrayList<>(),
                consumerList = new CopyOnWriteArrayList<>();
        /**
         * producer和consumer共同享用一个Exchanger，并使用它来交换对象
         */
        exec.execute(new ExchangerProducer<>(xc, BasicGenerator.create(Fat.class),producerList));
        exec.execute(new ExchangerConsumer<>(xc,consumerList));
        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();
    }
}
