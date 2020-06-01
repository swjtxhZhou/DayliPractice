package Algorithem.DynamicPlan.背包问题;

public class CanPartiton {
    /**
     * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * 每个数组中的元素不会超过 100
     * 数组的大小不会超过 200
     * 输入: [1, 5, 11, 5] 输出: true
     * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
     * 输入: [1, 2, 3, 5] 输出: false
     * 解释: 数组不能分割成两个元素和相等的子集
     */
    public boolean canPartition(int[] nums) {
        if(nums.length==0)return false;
        int cnt = 0;
        for(int num:nums){
            cnt+=num;
        }
        if(cnt%2!=0){
            return false;
        }
        int W = cnt/2;
        int length = nums.length;
        boolean[] dp = new boolean[W+1];
        dp[0] = true;
        for(int num:nums){//0-1背包一个物品只能用一次
            for(int i=W;i>=num;i--){//从后往前，每次循环只要i>=num,那么至少会由dp[num]为true，就会动态更新dp数组
                dp[i]=dp[i]||dp[i-num];
            }
        }
        return dp[W];
    }
}
