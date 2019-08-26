package August26th.Finally.practice;
/**
 * finally子句总是会执行，再一个方法中可以多点返回，并且可以保证重要的清理工作仍旧会执行
 */

import static java.lang.System.out;
public class MutipleReturns {
    public static void f(int i){
        System.out.println("Initialization that requires cleanup");
        try{
            out.println("point 1");
            if(i==1)return;
            out.println("point 2");
            if(i==2)return;
            out.println("point 3");
            if(i==3)return;
            out.println("end");
            return;
        }finally{
            out.println("Performing cleanup");
        }
    }
    public static void main(String[] args){
        for(int i=0;i<4;i++){
            f(i);
        }
    }
}
