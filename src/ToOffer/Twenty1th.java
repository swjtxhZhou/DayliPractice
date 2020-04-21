package ToOffer;

public class Twenty1th {
    /**
     * 调整数组顺序使奇数位于偶数前面,需要保证奇数和奇数，偶数和偶数之间的相对位置不变，这和书本不太一样
     * 方法一：创建一个新数组，时间复杂度 O(N)，空间复杂度 O(N)。
     */
    public void reOrderArray(int[] nums) {
        // 奇数个数
        int oddCnt = 0;
        for (int x : nums)
            if (!isEven(x))
                oddCnt++;
        int[] copy = nums.clone();
        int i = 0, j = oddCnt;
        for (int num : copy) {
            if (num % 2 == 1)
                nums[i++] = num;
            else
                nums[j++] = num;
        }
    }
    private boolean isEven(int x) {
        return x % 2 == 0;
    }
}
