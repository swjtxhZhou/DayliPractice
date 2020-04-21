package thinkingInJava.August23th.part3;

import static java.lang.System.out;
public class ExceptionMethods {
    public static void main(String[] args){
        try{
            throw new Exception("My Exception");
        }catch(Exception e){
            System.out.println("Caught Exception");
            System.out.println("getMessage():"+e.getMessage());//得到抛出异常时带的消息
            System.out.println("getLocalizedMessage():"+e.getLocalizedMessage());//作用同getMessage()一样
            out.println("toString():"+e);
            out.println("printStackTrace():");
            e.printStackTrace(out);
        }
    }
}
