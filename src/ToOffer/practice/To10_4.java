package ToOffer.practice;

import java.util.Arrays;

public class To10_4 {
    /**
     * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * f(n)=f(n-1)+f(n-2)+....+f(2)+f(1)+1;
     * 初始基，f(1)=1,f(2)=2
     */
    public int JumpFloorII(int target) {
        if(target<=2)return target;
        int[] dp = new int[target+1];
        Arrays.fill(dp,1);
        for(int i=2;i<=target;i++){
            for(int j=1;j<i;j++){
                dp[i]+=dp[j];
            }
        }
        return dp[target];
    }

}
