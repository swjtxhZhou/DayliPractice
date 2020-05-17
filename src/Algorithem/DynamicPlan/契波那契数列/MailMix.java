package Algorithem.DynamicPlan.契波那契数列;

public class MailMix {
    /**
     * 题目描述：有 N 个 信 和 信封，它们被打乱，求错误装信方式的数量（所有信封都没有装各自的信）。
     * 定义一个数组 dp 存储错误方式数量，dp[i] 表示前 i 个信和信封的错误方式数量。假设第 i 个信装到第 j 个信封里面，而第 j 个信装到第 k 个信封里面。根据 i 和 k 是否相等，有两种情况：
     * i==k，交换 i 和 j 的信后，它们的信和信封在正确的位置，但是其余 i-2 封信有 dp[i-2] 种错误装信的方式。由于 j 有 i-1 种取值，因此共有 (i-1)*dp[i-2] 种错误装信方式。
     * i != k，交换 i 和 j 的信后，第 i 个信和信封在正确的位置(这里应该是第j个信封和信在正确位置)，其余 i-1 封信有 dp[i-1] 种错误装信方式。由于 j 有 i-1 种取值(这里应该是只有i-2个位置才对吧？？？)，因此共有 (i-1)*dp[i-1] 种错误装信方式。
     * 综上所述，错误装信数量方式数量为：dp[i] = (i-1)*dp[i-2]+(i-1)*dp[i-1]
     */
    public int wrongMehod(int nums){
        if(nums<=1)return 0;
        //两封信时的方法
        if(nums==2)return 1;
        int pre2 = 0;
        int pre1 = 1;
        for(int i=3;i<=nums;i++){
//            int res = (i-1)*pre2+(i-1)*pre1;
            int res = (i-1)*pre2+(i-2)*pre1;//我认为这样才应该是正确的
            pre2 = pre1;
            pre1 = res;
        }
        return pre1;
    }

}
