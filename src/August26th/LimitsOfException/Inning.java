package August26th.LimitsOfException;

public abstract class Inning {
    public Inning()throws BaseBallException{}
    public void event()throws BaseBallException{}
    public abstract void atBat()throws Strike, Foul;
    public void walk(){}
}
