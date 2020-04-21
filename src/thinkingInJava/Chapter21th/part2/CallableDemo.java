package thinkingInJava.Chapter21th.part2;

import java.util.ArrayList;
import java.util.concurrent.*;

class TaskWithResults implements Callable<String>{
    private int id;
    public TaskWithResults(int id){
        this.id = id;
    }
    public String call(){
        return "result of TaskWithResults"+id;
    }
}
public class CallableDemo {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for(int i=0; i<10;i++){
            /**
             * Runnable是执行工作的独立任务，但是他不返回任何值
             * 若希望任务完成时能够返回一个值，可以实现Callable
             * Callable是一种具有类型参数的泛型，它的类型参数是从方法call（）中返回的值，并且必须使用ExecutorService。submit（）调用
             * submit（）方法产生Future对象，他用Callable返回结果的特定类型进行了参数化。可以使用isDone（）方法来查询Future是否已经完成
             * 当任务完成时，它具有一个结果，可以调用get（）来获取结果。
             * 也可以不使用isDone（）进行检擦就直接掉用get（），这种情况下get（）将阻塞，直至结果准备就绪，
             */
            results.add(exec.submit(new TaskWithResults(i)));
        }
        for(Future<String> fs:results){
            try{
//                if(fs.isDone()){
                    System.out.println(fs.get());
//                }
            }catch(InterruptedException e){
                System.out.println(e);
                return;
            }catch(ExecutionException e){
                System.out.println(e);
            }finally {
                exec.shutdown();
            }
        }
    }
}
