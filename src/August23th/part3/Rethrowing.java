package August23th.part3;
import static java.lang.System.out;
public class Rethrowing {
    public static void f()throws Exception{
        out.println("originating the exception in f()");
        throw new Exception("throw from f()");
    }
    public static void g() throws Exception{
        try{
            f();
        }catch(Exception e){
            out.println("Inside g(),e.printStackTrace()");
            e.printStackTrace(out);
            /**
             * 再次抛出
             */
            throw e;
        }
    }
    public static void h() throws Exception{
        try{
            g();
        }catch (Exception e){
            out.println("Inside h(),e.printStackTrace()");
            e.printStackTrace(out);
            throw (Exception) e.fillInStackTrace();
        }
    }
    public static void main(String[] args){
        try{
            g();
        }catch(Exception e){
            out.println("main:printStackTrace()");
            e.printStackTrace(out);
        }
        try{
            h();
        }catch(Exception e){
            out.println("main:printStackTrace()");
            e.printStackTrace(out);
        }
    }
}
