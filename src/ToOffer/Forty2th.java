package ToOffer;

public class Forty2th {
    /**
     * 动态规划的题目还是不太会
     * 连续子数组的最大和
     * {6, -3, -2, 7, -15, 1, 2, 2}，连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）。
     */
    public int FindGreatestSumOfSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int greatestSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : nums) {
            //判断如果之前的所有的和为负数或者是0，那么当前数加上sum就会变小，如果大于0，当前数加上sum只会变大
            sum = sum <= 0 ? val : sum + val;
            greatestSum = Math.max(greatestSum, sum);
        }
        return greatestSum;
    }

}
