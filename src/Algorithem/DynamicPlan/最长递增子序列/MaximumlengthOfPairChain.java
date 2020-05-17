package Algorithem.DynamicPlan.最长递增子序列;

import java.util.Arrays;

public class MaximumlengthOfPairChain {
    /**
     * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
     *
     * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
     *
     * 给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。\
     * 输入: [[1,2], [2,3], [3,4]] 输出: 2 解释: 最长的数对链是 [1,2] -> [3,4]
     * 给出数对的个数在 [1, 1000] 范围内。
     * dp[i]存储以pairs[i]结尾的最长链的长度
     */
    public int findLongestChain(int[][] pairs){
        if(pairs==null||pairs.length==0)return 0;
        //对所有的整数对进行排序
        Arrays.sort(pairs,(o1, o2) -> (o1[0]-o2[0]));
        int n = pairs.length;
        int[] dp = new int[n];
        //初始化动态数组，因为每个组里面至少有一个整数组
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(pairs[j][1]<pairs[i][0]){
                    //可以更新
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        //这里是找最长链，dp[n-1]不一定是最长链
        return Arrays.stream(dp).max().orElse(0);
    }
    
}
