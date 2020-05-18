package Algorithem.DynamicPlan.背包问题;

public class FindTargetSumWays {
    /**
     * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
     * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     * 输入: nums: [1, 1, 1, 1, 1], S: 3 输出: 5 解释:
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     * 一共有5种方法让最终目标和为3。
     * 组非空，且长度不会超过20。
     * 初始的数组的和不会超过1000。
     * 保证返回的最终结果能被32位整数存下
     * 该问题可以转换为 Subset Sum 问题，从而使用 0-1 背包的方法来求解。
     * 可以将这组数看成两部分，P 和 N，其中 P 使用正号，N 使用负号，有以下推导：
     * sum(P) - sum(N) = target
     * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     * 2 * sum(P) = target + sum(nums)
     * 只要找到一个子集，令他们都等于正号，并且和等于（target+sum（nums））/2,就证明存在解
     */
    public int findTargetSumWays(int[] nums,int S){
        int sum =0;
        for(int num:nums){
            sum+=num;
        }
        if(sum<S||(sum+S)%2==1){
            //如果数组的所有集合都小于目标值
            //如果需要累加的值被2不能除尽，则不存在解
            return 0;
        }
        int W = (sum+S)/2;
        //dp[i]表示满足累加为i的种类数量
        int[] dp = new int[W+1];
        dp[0]=1;
        for(int num:nums){
            for(int i=W;i>=num;i--){
                //每一次大循环之后会有新的num添加进来，dp[i]更新为原来的解数量dp[i]+dp[i-num],因为dp[i-num],i-num加上num之后也是为i。
                dp[i]=dp[i]+dp[i-num];
            }
        }
        return dp[W];

    }
}
