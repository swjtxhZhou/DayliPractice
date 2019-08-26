package August23th;

public class FullConstructors {
    public static void f()throws MyException{
        System.out.println("throwing MyException from f()");
        throw new MyException();
    }
    public static void g()throws MyException{
        System.out.println("throwing MyException from g()");
        throw new MyException("originated in g()");
    }
    public static void main(String[] args){
        try{
            f();
        }catch(MyException e){
            /**
             * printStackTrace()方法，将打印“从方法调用处直到异常抛出处”
             * 这里，信息被发送到System.out，并自动的被捕获和显示在输出中，
             * 若调用默认版本 e.printStackTrace()，则信息将被输出到标准错误流
             */
            e.printStackTrace(System.out);
        }
        try{
            g();
        }catch(MyException e){
            e.printStackTrace();//没有System.out将会直接报错
        }

    }
}
