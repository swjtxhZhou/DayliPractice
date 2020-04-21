package thinkingInJava.Chapter21th.part3;

public class EvenGenerator extends IntGenerator {
    private int currentEvenValue ;
    public int next(){
        ++currentEvenValue;//Danger point here,在java中，递增不是原子性的操作，在递增过程中任务可能会被线程机制挂起
        ++currentEvenValue;
        return currentEvenValue;
    }
    public static void main(String[] args){
        EvenChecker.test(new EvenGenerator());
    }
}
