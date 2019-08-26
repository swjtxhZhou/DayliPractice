package August23th.part3;

public class ReThrowNew {
    public static void f() throws OneException{
        System.out.println("originating the Exception in f()");
        throw new OneException("throw from f()");
    }
    public static void main(String[] args){
        try{
            try{
                f();
            }catch(OneException e){
                System.out.println("Caught in inner try,e.printStackTrace()");
                e.printStackTrace(System.out);
                throw new TwoException("from inner try");
            }
        }catch (TwoException t){
            System.out.println("Caught in outer try, e.printStackTrace()");
            t.printStackTrace(System.out);
        }
    }
}
