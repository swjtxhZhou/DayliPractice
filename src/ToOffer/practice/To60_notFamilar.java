package ToOffer.practice;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class To60_notFamilar {
    /**
     * 把 n 个骰子扔在地上，求点数和为 s 的概率。
     * 题解思路：使用一个二维数组dp存储点数出现的次数，其中dp[i][j]表示前i个骰子产生点数j的次数。
     * 空间复杂度O（n2）
     * 就是最终得到一个所有可能点数会出现的次数，然后除以总共掷骰子的可能出现的情况6的n次方
     */
    public List<Map.Entry<Integer,Double>> dicesSum(int n){
        final int face = 6;
        final int pointNum = face*n;
        long[][] dp = new long[n+1][pointNum+1];

        for(int i=1;i<=face;i++){
            dp[1][i] = 1;//一个骰子只会丢出1-6数字一次
        }
        for(int i=2;i<=n;i++){
            for(int j=i;j<=pointNum;j++){//j表示置出的数字大小，最小是根据骰子的数量决定的
                for(int k=1;k<=face&&k<=j;k++){
                    /**
                     * 这一句要好好分析一下，当前是i个骰子和掷出和为j的次数
                     * 状态取决于i-1个骰子掷出从j-1,j-2,j-3,j-4,j-5,j-6的情况，
                     * 此时假设j大于6，因为新加入一个骰子可能掷出1-6的可能性
                     */
                    dp[i][j] += dp[i-1][j-k];
                }

            }
        }
        final double totalNum = Math.pow(6,n);//这是总的可能掷出的次数
        List<Map.Entry<Integer,Double>> ret = new ArrayList<>();
        for(int i=n;i<=pointNum;i++){
            ret.add(new AbstractMap.SimpleEntry<>(i,dp[n][i]/totalNum));
        }
        return ret;
    }
}
