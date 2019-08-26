package August26th;

import August23th.part2.MyException2;

public class MyExceptionDemo {


    public static void f() throws MyException {
        throw new MyException();
    }
    public static void g() throws MyException {
        try {
            f();
        }catch (MyException e){
//            e.printStackTrace(System.out);
//            throw new MyException2();
            /**
             * 包装成一个RuntimeException
             */
//            MyException my = new MyException();
//            e.initCause(new RuntimeException());
//            throw e;
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args){
        try {
            MyExceptionDemo.f();
        }catch (MyException e){
            e.printStackTrace(System.out);
        }
        try{
            MyExceptionDemo.g();
        }catch (MyException e){
            e.printStackTrace(System.out);
        }

    }
}
