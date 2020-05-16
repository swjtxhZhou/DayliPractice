package Algorithem.DynamicPlan;

public class HouseRapper {
    /**
     * 题目描述：抢劫一排住户，但是不能抢邻近的住户，求最大抢劫量。
     * 定义 dp 数组用来存储最大的抢劫量，其中 dp[i] 表示抢到第 i 个住户时的最大抢劫量。
     * 由于不能抢劫邻近住户，如果抢劫了第 i -1 个住户，那么就不能再抢劫第 i 个住户，所以dp[i]=max(dp[i-2]+nums[i],dp[i-1])
     * 所以在到第i排的时候要考虑第i-2排加上第i排的数量和i-1排的数量的大小关系
     */
    public int robs(int[] nums){
        if(nums.length==1){return nums[0];}
        if(nums.length==2){return nums[1];}
        int pre2 = nums[0];
        int pre1 = nums[1];
        int res=0;
        for(int i=2;i<nums.length;i++){
            res = Math.max(pre2+nums[i],pre1);
            pre2 = pre1;
            pre1 = res;
        }
        return res;
    }

}
