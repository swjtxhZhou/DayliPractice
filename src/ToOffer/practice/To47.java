package ToOffer.practice;

public class To47 {
    /**
     * 小东所在公司要发年终奖，而小东恰好获得了最高福利，他要在公司年会上参与一个抽奖游戏，游戏在一个6*6的棋盘上进行，上面放着36个价值不等的礼物，每个小的棋盘上面放置着一个礼物，他需要从左上角开始游戏，每次只能向下或者向右移动一步，到达右下角停止，一路上的格子里的礼物小东都能拿到，请设计一个算法使小东拿到价值最高的礼物。
     *
     * 给定一个6*6的矩阵board，其中每个元素为对应格子的礼物价值,左上角为[0,0],请返回能获得的最大价值，保证每个礼物价值大于100小于1000。
     * 思想：动态规划
     *要求是从左上角开始出发，那么初始基需要初始化dp[0][0]dp[0][x]dp[x][0],
     * 编程的时候犯了一个错误，在初始化dp[0][x]和dp[x][0]时的动态方程写成dp[i][j]+=dp[i-1][j]的形式了，没有加上该格的价值。
     * 然后动态方程就是dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+board[i][j];
     */
    public int getMost(int[][] board) {
        if(board==null||board.length==0||board[0].length==0){
            return 0;
        }
        int row = board.length;
        int col = board[0].length;
        int[][] dp = new int[row][col];
        //初始化初始基
//        dp[0][0] = board[0][0];
        //初始化dp[0][x]
//        for(int i=1;i<col;i++){
//            dp[0][i] += dp[0][i-1];
//        }
//        //初始化dp[x][0]
//        for(int i=1;i<row;i++){
//            dp[i][0] += dp[i-1][0];
//        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++) {
                if(i==0&&j==0){
                    dp[i][j] =board[i][j];
                }else if (i == 0) {
                    dp[i][j] += dp[i][j - 1]+board[i][j];
                } else if (j == 0) {
                    dp[i][j] += dp[i - 1][j]+board[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + board[i][j];
                }
            }
        }
        return dp[row-1][col-1];
    }
}
