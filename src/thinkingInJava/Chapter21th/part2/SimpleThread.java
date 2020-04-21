package thinkingInJava.Chapter21th.part2;

/**
 * 没有实现Runnable，而是继承了Thread这种，可替换方式
 */
public class SimpleThread extends Thread{
    private int countDown = 5;
    private static int threadCount = 0;
    public SimpleThread(){
        super(Integer.toString(++threadCount));
        start();
    }
    public String toString(){
        return "#"+getName()+"("+countDown+"), ";
    }
    public void run(){
        while(true){
            System.out.println(this);
            if(--countDown==0){
                return;
            }
//            Thread.yield();
        }
    }
    public static void main(String[] args){
        for(int i=0;i<5;i++){
            new SimpleThread();
        }
    }
}
