package Algorithem.DynamicPlan.MatrixPath;

import java.util.Arrays;

public class UniquePath {
    /**
     * 矩阵的总路径数
     * 统计从矩阵左上角到右下角的路径总数，每次只能向右或者向下移动。
     */
    //二维数组
    public int uniquePath(int row,int col){
        int[][] dp= new int[row][col];
        dp[0][0]=0;
//        dp[0][1]=1;
        Arrays.fill(dp[0],1);
        for(int i=1;i<row;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[row-1][col-1];
    }
//一维数组
    public int uniquePath_onePlat(int row,int col){
        int[] dp = new int[col];
        Arrays.fill(dp,1);
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                //dp[0]一直会是1，因为往下走只有一种走法
                //每迭代一行就会更新除了dp[0]之外的所有dp[]元素。
                dp[j]=dp[j]+dp[j-1];
            }
        }
        return dp[col-1];
    }
}

