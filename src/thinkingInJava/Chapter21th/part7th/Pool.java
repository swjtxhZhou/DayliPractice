package thinkingInJava.Chapter21th.part7th;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * 计数信号量允许n个任务同时访问这个资源。你还可以将信号量看作是在向外分发使用资源的“许可证”。尽管实际上没有使用任何许可证对象
 *
 * 对象池的概念，它管理着数量有限的对象，当要使用对象是可以签出他们，而在用户使用完毕时，可以将它们签回。这种功能可以被封装到一个泛型类中
 * @param <T>
 */
public class Pool<T> {
    private int size;
    private List<T> items = new ArrayList<>();
    /**
     * checkedOut数组可以跟踪被签出的对象，并且可以通过getItem（）和releaseItem（）方法管理。而这些都将由semaphore类型的available来加以确认
     */
    private volatile boolean[] checkedOut;
    private Semaphore available;
    public Pool(Class<T> classObject,int size){
        this.size = size;
        checkedOut = new boolean[size];
        available = new Semaphore(size, true);
        for(int i= 0;i<size;i++){
            try{
                /**
                 * 构造器使用newInstance（）来把对象加载到池中。如果你需要一个新对象，可以调用checkeOut（），并且在使用完之后，将其递给checkIn（）。
                 */
                items.add(classObject.newInstance());
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 获取一个对象,如果没有任何信号量许可证可用（意味着池中没有更多对象了）。available将阻塞调用过程。
     * @return
     * @throws InterruptedException
     */
    public T checkOut() throws InterruptedException{
        available.acquire();
        return getItem();
    }

    /**
     * 归还一个对象，若签入的对象有效，则会向信号量返回一个许可证。
     * @param x
     */
    public void checkIn(T x){
        if(releaseItem(x)) available.release();
    }
    private synchronized T getItem(){
        for(int i=0;i<size;++i){
            /**
             * 若checkedOut是false，则让checkedOut等于true，然后返回列表中当前索引值的对象
             */
            if(!checkedOut[i]){
                checkedOut[i]=true;
                return items.get(i);
            }
        }
        return null;
    }
    private synchronized  boolean releaseItem(T item){
        int index = items.indexOf(item);
        if(index == -1){
            return false;
        }
        if(checkedOut[index]){
            checkedOut[index] =false;
            return true;
        }
        return false;
    }
}
