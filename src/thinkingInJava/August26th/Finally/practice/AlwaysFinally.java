package thinkingInJava.August26th.Finally.practice;

/**
 * 异常没有被当前的异常执行程序捕获的情况下，异常处理机制也会在跳到更高一层的异常处理程序之前，执行finally子句
 *
 * 当涉及break和continue语句时，finally子句任然会得到执行。
 */
public class AlwaysFinally {
    public static void main(String[] args){
        System.out.println("first try block");
        try{
            System.out.println("entering second block");
            try{
                throw new FourException();
            }finally {
                System.out.println("finally in 2nd try block");
            }
        }catch (FourException e){
            System.out.println("caught FourException in first block");
        }finally{
            System.out.println("finally in 1st try block");
        }
    }
}
