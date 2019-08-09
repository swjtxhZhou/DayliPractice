package August8th.part4_controller;

public abstract class Event {
    private long eventTime;
    /**
     * delayTime在构造器中进行初始化
     */
    protected final long delayTime;
    public Event(long delayTime){
        this.delayTime = delayTime;
    }
    public void start(){
        /**
         * 返回一个纳秒精度的时间
         */
        eventTime = System.nanoTime()+delayTime;
    }
    public boolean ready(){
        return System.nanoTime() >= eventTime;
    }
    public abstract void action();

}
