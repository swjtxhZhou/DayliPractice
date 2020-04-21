package thinkingInJava.August26th.Finally.practice;

public class ExceptionSilencer {
    public static void main(String[] args){
        try{
            throw new RuntimeException();
        }finally{
            /**
             * 在finally子句中返回，即使抛出了异常，它也不会产生任何输出
             * 这是一种更加简单丢失异常的方式
             */
            return;
        }
    }
}
