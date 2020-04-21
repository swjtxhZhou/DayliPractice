package thinkingInJava.August26th.Finally.practice;

/**
 * finally总能运行
 */
public class FinallyWorks {
    static int count = 0;
    public static void main(String[] args){
        /**
         * count第一个循环为0，抛出ThreeException(),然后执行finally
         * 第二个循环打印“No Exception”,然后执行finally
         */
        while(true) {
            System.out.println("count:"+count);
            try {
                if (count++ == 0) {
                    throw new ThreeException();
                }
                System.out.println("No Exception");
            }catch (ThreeException e){
                System.out.println("ThreeException");
            }finally {
                System.out.println("In finally clause");
                if(count == 2) break;
            }
        }
    }
}
