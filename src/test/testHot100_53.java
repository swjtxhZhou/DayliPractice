package test;

public class testHot100_53 {
    public static int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[1];
        }
        //使用动态规划，当前位置的最大值取决于“前一个位置的最大值”与“前一个位置的最大值”+当前的值
        int sum = 0;
        int maxres = nums[0];
        for(int i=0;i<nums.length;i++){
            if(sum<0){
                //如果上一个位置的和小于0，说明对结果没有增益，重新从当前位置开始计算sum
                sum = nums[i];
            }else{
                //如果上一个位置的和大于0，说明对结果有增益，将当前位置的数值加上
                sum+=nums[i];
            }
            maxres = Math.max(sum,maxres);//不断尝试更新最大值
        }
        return maxres;
    }
    public static void main(String[] args){
        int res = testHot100_53.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(res);
    }
}
