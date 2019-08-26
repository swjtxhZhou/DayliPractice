package August26th.Finally.practice;

public class WithFinally {
    static Switch sw = new Switch();
    public static void main(String[] args){
        try{
            sw.on();
            OnOffSwitch.f();
            throw new RuntimeException();
        }catch (OnOffException e){
            e.printStackTrace();
        }catch (OnOffException1 e){
            e.printStackTrace();
        }finally {
            /**
             * 保证在任何情况下都能得到执行
             */
            sw.off();
        }
    }
}
