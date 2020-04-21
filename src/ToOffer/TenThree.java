package ToOffer;

public class TenThree {
    /**
     * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * f(n-1) = f(n-2) + f(n-3) + ... + f(0)
     * f(n) = f(n-1) + f(n-2) + ... + f(0)
     * f(n) = 2*f(n-1)
     * 所以 f(n) 是一个等比数列
     */
    public int JumpFloorII(int target){
        return (int)Math.pow(2,target-1);
    }
}
