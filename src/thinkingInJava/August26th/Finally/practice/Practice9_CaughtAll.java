package thinkingInJava.August26th.Finally.practice;

public class Practice9_CaughtAll {
    static int i;
    static void f()throws OnOffException1,OnOffException, FourException{
        if(i== 1){
            throw new OnOffException();
        }
        if(i==2){
            throw new OnOffException1();
        }
        if(i == 3){
            throw new FourException();
        }
    }
    public void setException(int i){
        this.i = i;
    }
    public static void main(String[] args){
        Practice9_CaughtAll p = new Practice9_CaughtAll();
//        p.setException(2);
        try{
            f();
        }catch (OnOffException | OnOffException1 | FourException e){
            /**
             * 用一个catch子句捕获三种异常
             */
            e.printStackTrace(System.out);
        }finally {
            System.out.println("finally");
        }
    }
}
