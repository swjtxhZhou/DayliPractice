package August26th.LimitsOfException;

/**
 * 当覆盖方法的时候，只能抛出在基类方法的异常说明里列出的那些异常
 * 这是施加到异常上面的限制
 */
public class StormInning extends Inning implements Storm{
    public StormInning()throws BaseBallException,RainedOut{}
    public StormInning(String s)throws BaseBallException,Foul{}
//    void walk()throws PopFoul{}常规方法只能按照基类的格式，?????
//    public void event()throws RainedOut{}//接口方法与基类方法的exception不一致
    public void rainHard()throws RainedOut{}//该方法没有在基类当中，如果接口里定义的方法不是来自基类，那么此方法抛出什么样的异常都没问题。
    public void event(){}//此处可以不声明丢出的Exception，Storm里的event()方法不能改变在Inning中的event（）方法的异常接口。
    public void atBat()throws PopFoul{}//抽象方法的实现，可以抛出原Exception的导出异常
    public void f()throws UmpireArgument{}
    public static void main(String[] args){
        try{
            StormInning si = new StormInning();
            si.atBat();
            si.f();//不用catch UmpireArgument 因为继承自BaseballException
        }catch (PopFoul e){
            System.out.println("Pop foul");
        }catch (RainedOut e){
            System.out.println("Rained out");
        }catch (BaseBallException e){
            System.out.println("Generic baseball exception");
        }
        try{
            Inning i = new StormInning();//向上转型为基类对型
            i.atBat();
            /**
             * 必须catch基类的异常
             */
        }catch(Strike e){
            System.out.println("Strike");
        }catch(Foul e){
            System.out.println("Foul");
        }catch(RainedOut e){
            System.out.println("Rained out");
        }catch (BaseBallException e){
            System.out.println("Generic baseball exception");
        }
    }
}
