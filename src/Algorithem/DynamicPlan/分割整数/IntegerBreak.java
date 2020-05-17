package Algorithem.DynamicPlan.分割整数;

public class IntegerBreak {
    /**
     * 分割整数最大乘积
     * 题目描述：For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
     */
    public int integerBreak(int n){
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            for(int j=1;j<i-1;j++){
                dp[i]=Math.max(dp[i],Math.max(dp[i-j]*j,(i-j)*j));
            }
        }
        return dp[n];
    }
}
