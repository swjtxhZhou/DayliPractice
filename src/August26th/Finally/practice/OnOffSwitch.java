package August26th.Finally.practice;

/**
 * 确保程序关闭时，switch是关闭的
 */
public class OnOffSwitch {
    private static Switch sw = new Switch();
    public static void f()throws OnOffException,OnOffException1,RuntimeException{
    }
    public static void main(String[] args){
        try{
            sw.on();
            f();
            sw.off();

        }catch(OnOffException e){
            e.printStackTrace(System.out);
            sw.off();
        }catch (OnOffException1 e){
            e.printStackTrace(System.out);
            sw.off();
        }
    }
}
