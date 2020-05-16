package Algorithem.DynamicPlan.MatrixPath;

public class MiniMumPathSum {
    /**
     * [[1,3,1],
     *  [1,5,1],
     *  [4,2,1]]
     * Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
     * 题目描述：求从矩阵的左上角到右下角的最小路径和，每次只能向右和向下移动。
     */
    //二维动态规划
    public int minPathSum(int[][] grid){
        if(grid==null||grid.length==0||grid[0].length==0)return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        //从左上角开始
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0&&j==0){
                    dp[i][j]=grid[i][j];
                }else if(i==0){
                    //在第一行,因为只能向下走或者是向左走,所以上一个元素一定是在左边
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                }else if(j==0){
                    //在第一列，同上，上一个元素一定是在上面
                    dp[i][j] = grid[i][j] +dp[i-1][j];
                }else{
                    //判断一下，这个空格的上面元素更大还是左边元素更大
                    dp[i][j] = grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[row-1][col-1];
    }
    //一位数组
    

}
