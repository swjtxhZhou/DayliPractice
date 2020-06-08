package ToOffer.practice;

public class To16 {
    /**
     * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方
     * 这里如果用常规方法（不考虑使用库函数Math.pow(base,exponent)）第一步想到的就是把base通过循环乘以base次，那么它的时间复杂度就是O（n），其中n等于base,注意要考虑exponent的正负问题
     */
    public double Power_common(double base, int exponent) {
        if(base==0)return 0;
        if(exponent==0)return 1;
        boolean isNegative=false;
        if(exponent<0){
            isNegative=true;
            exponent = -exponent;
        }
        double res=1;
        for(int i=0;i<exponent;i++){
            res*=base;
        }
        return isNegative?1/res:res;
    }
    //接下来就是优化版本，时间复杂度会优化成O（logN），通过递归实现
    public double Power(double base, int exponent) {
        if(base==0)return 0;
        if(exponent==0)return 1;
        boolean isNegative=false;
        if(exponent<0){
            isNegative=true;
            exponent = -exponent;
        }
        double pow = Power(base*base,exponent/2);
        if(exponent%2!=0){
            pow*=base;
        }
        return isNegative?1/pow:pow;
    }
}
