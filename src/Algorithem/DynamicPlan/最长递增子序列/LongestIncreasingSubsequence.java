package Algorithem.DynamicPlan.最长递增子序列;

public class LongestIncreasingSubsequence {
    /**
     * 最长递增子序列
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     *
     * 示例:
     *
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     * 说明:
     * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
     * 你算法的时间复杂度应该为 O(n2) 。
     * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
     */
    public int lengthOfLIS(int[] nums){
        if(nums.length==0){return 0;}
        int n = nums.length;
        int[] dp=new int[n];
        int maxans=1;//最大长度
        dp[0]=1;
        for(int i=1;i<n;i++){
            int maxVal=0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    //如果比以j结尾的值更大，那么需要更新
                    maxVal = Math.max(dp[j],maxVal);
                }
            }
            dp[i]=maxVal+1;
            maxans = Math.max(maxans,dp[i]);
        }
        return maxans;
    }
}
