package Algorithem.DynamicPlan.分割整数;



import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {
    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * 题目描述：For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
     *
     * 应该需要一个列表专门存放小于给定整数的所有的完全平方数
     */
    public int numSquares(int n){
        List<Integer> squareList = generateList(n);
        int[] dp= new int[n+1];
        for(int i=1;i<=n;i++){
            int min = Integer.MAX_VALUE;
            for(int square:squareList){
                if(square>i){
                    break;
                }//这一步动态更新最低的值
                min = Math.min(min,dp[i-square]+1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
    public List<Integer> generateList(int n){
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<n;i++){
            int val = (int)Math.pow(i,2);
            if(n>val){
                list.add(val);
            }else if(n<val){
                break;
            }
        }
        return list;
    }
}
