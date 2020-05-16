package Algorithem.DynamicPlan;

public class HouseRapper2 {
    /**
     * 强盗在环形街区抢劫
     * 跟不是环形街区的不同情况就是在第一个户和最后一户是相邻的
     * 所以只需要把nums[]分成两段来计算，，并取最大值
     */
    public int rob(int[] nums){
        if(nums==null||nums.length==0){
            return 0;
        }
        int n = nums.length;
        if(n==1)return nums[0];
        //将头部和尾部分开来计算
        return Math.max(rob(nums,0,n-2),rob(nums,1,n-1));
    }
    public int rob(int[] nums,int start,int end){
        int pre1 = nums[start+1];
        int pre2 = nums[start];
        for(int i=start+2;i<=end;i++){
            int res = Math.max(pre2+nums[i],pre1);
            pre2=pre1;
            pre1=res;
        }
        return pre1;
    }

}
