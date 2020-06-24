package ToOffer.practice;

public class To42 {
    /**
     * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
     *
     * 连续子数组的最大和
     * 求最大值考虑到贪心算法
     * 这里的贪心思想就是，如果和的结果小于0了就重新开始，会有一个最大值动态变化。
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0)return 0;
        int greatSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int num:array){
            sum = sum<=0 ? num:sum+num;//之前的和为负数或者0就直接抛弃点
            greatSum = Math.max(sum,greatSum);//每次都会比较

        }
        return greatSum;
    }
}
