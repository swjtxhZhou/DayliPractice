package thinkingInJava.ExceptionOfConstructor;

public class NeedsCleanUp2 extends NeedsCleanUp{
    public NeedsCleanUp2()throws ConstructorException{
        try{
//            super();调用父类构造器必须是子类构造器的第一句，所以不能使用try-catch语句捕获父类构造器抛出的异常
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
