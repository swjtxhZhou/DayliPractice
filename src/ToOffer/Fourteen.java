package ToOffer;

public class Fourteen {
    /**
     * 把一根绳子剪成多段，并且使得每段的长度乘积最大。
     *拆分规则：
     * 最优： 3 。把数字 nn 可能拆为多个因子 33 ，余数可能为 0,1,2 三种情况。
     * 次优： 2 。若余数为 2 ；则保留，不再拆为 1+1 。
     * 最差： 1 。若余数为 1；则应把一份 3 + 1 替换为 2 + 2，因为 2×2>3×1
     * 贪心
     * 尽可能多剪长度为 3 的绳子，并且不允许有长度为 1 的绳子出现。如果出现了，就从已经切好长度为 3 的绳子中拿出一段与长度为 1 的绳子重新组合，把它们切成两段长度为 2 的绳子。
     *
     * 证明：当 n >= 5 时，3(n - 3) - n = 2n - 9 > 0，且 2(n - 2) - n = n - 4 > 0。因此在 n >= 5 的情况下，将绳子剪成一段为 2 或者 3，得到的乘积会更大。又因为 3(n - 3) - 2(n - 2) = n - 5 >= 0，所以剪成一段长度为 3 比长度为 2 得到的乘积更大。
     */
    //贪心
    public int integerBreak(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int timesOf3 = n / 3;//获得可以拿出整个3的个数
        if (n - timesOf3 * 3 == 1)//如果余数为1
            timesOf3--;//拿出一个3出来，和1一起分成两个2
        int timesOf2 = (n - timesOf3 * 3) / 2;//拿出2的个数
        return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
    }
    //动态规划
    public int integerBreak1(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j < i; j++)//
                //求出每次情况下最大值，在进行对比去最大值
                dp[i] = Math.max( dp[i], Math.max(j * (i - j), dp[j] * (i - j)) );
        return dp[n];
    }

}
