package ToOffer;

public class Sixteen {
    /**
     * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方。
     * 要考虑时间复杂度在内
     * 因为 (x*x)n/2 可以通过递归求解，并且每次递归 n 都减小一半，因此整个算法的时间复杂度为 O(logN)
     */
    //空间换时间的做法
    public double newPow(double base,int exponent){
        if(exponent==0)return 1;
        if(exponent==1)return exponent;
        boolean isNegative=false;//用来判断exponent是正数还是负数
        if(exponent<0){
            isNegative=true;
            exponent=-exponent;
        }
        double pow = newPow(base*base,exponent/2);//
        if(exponent%2!=0){
            pow=pow*base;
        }
        return isNegative?1/pow:pow;


    }
}
