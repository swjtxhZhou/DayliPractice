package Chapter21th.part2;

/**
 * 这与从Thread继承的差别不大，但是实现Runnable接口，可以使得你继承其他的类
 */
public class SelfManaged implements Runnable{
    private int countDown = 5;
    private Thread t = new Thread(this);

    /**
     * 在构造器中调用start（）对于简单的实例可能是安全的，
     * 但是这很容易带来问题，因为另一个任务可能会在构造器结束之前开始执行，这意味着该任务能够访问处于！！！不稳定状态的对象
     * 这是优选Executor而不是显式的创建Thread对象的另一个原因
     */
    public SelfManaged(){t.start();}
    public String toString(){
        return Thread.currentThread().getName()+"("+countDown+")";
    }
    public void run(){
        while(true){
            System.out.println(this);
            if(--countDown==0){
                return;
            }
        }
    }
    public static void main(String[] args){
        for(int i=0;i<5;i++){
            new SelfManaged();
        }
    }
}
