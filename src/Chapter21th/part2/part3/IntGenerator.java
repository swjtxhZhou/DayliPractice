package Chapter21th.part2.part3;

public abstract class IntGenerator {
    private volatile boolean canceled = false;//为了保证可视性
    public abstract int next();
    public void cancel(){canceled = true;}
    public boolean isCanceled(){
        return canceled;
    }
}
