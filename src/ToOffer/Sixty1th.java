package ToOffer;

import java.util.Arrays;

public class Sixty1th {
    /**
     * 扑克牌顺子
     * 五张牌，其中大小鬼为癞子，牌面为 0。判断这五张牌是否能组成顺子。
     */
    public boolean isContinuous(int[] nums) {

        if (nums.length < 5)
            return false;

        Arrays.sort(nums);

        // 统计癞子数量
        int cnt = 0;
        for (int num : nums)
            if (num == 0)
                cnt++;

        // 使用癞子去补全不连续的顺子
        for (int i = cnt; i < nums.length - 1; i++) {
            //nums[i+1]不会越界，因为到nums.length-1就会跳出循环
            if (nums[i + 1] == nums[i])//如果出现了重复的牌，返回失败
                return false;
            /**
             * 因为排过序，并且已经去掉了重复的情况
             * 如果num[i+1]只比nums[i]大1，不会消耗赖子
             * 如果大于超过了1就会消耗赖子，消耗赖子的数量是超过的值减1
             */
            cnt -= nums[i + 1] - nums[i] - 1;
        }
        //如果发现消耗的赖子超过了赖子的数量
        return cnt >= 0;
    }
}
