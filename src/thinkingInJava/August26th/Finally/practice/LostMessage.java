package thinkingInJava.August26th.Finally.practice;

public class LostMessage {
    void f()throws VeryImportantException{
        throw new VeryImportantException();
    }
    void dispose()throws HoHumException{
        throw new HoHumException();
    }
    public static void main(String[] args){
        try{
            LostMessage lm = new LostMessage();
            try{
                lm.f();
            }finally{
                /**
                 * finally子句造成VeryImportantException不见了，被HoHumException取代了
                 * 这是一种非常糟糕的编程错误
                 */
                lm.dispose();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
