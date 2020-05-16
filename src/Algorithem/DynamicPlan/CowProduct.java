package Algorithem.DynamicPlan;

public class CowProduct {
    /**
     * 题目描述：假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死。第一年有 1 只小母牛，从第二年开始，母牛开始生小母牛。每只小母牛 3 年之后成熟又可以生小母牛。给定整数 N，求 N 年后牛的数量。
     * 第 i 年成熟的牛的数量为：dp[i] = dp[i-1]+dp[i-3];
     * 第i年成熟的牛的数量是去年的数量加上往前三年成熟母牛生的小牛的数量（其实就是前三年成熟母牛的数量）
     */
    public int matureCow(int n){
        if(n<0)return 0;
        //这个题目有bug，第二年小母牛就可以生了？
        int[] dp= new int[n+1];
        dp[0]= 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for(int i=4;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-3];
        }
        return dp[n];
    }

}
