package Algorithem.DynamicPlan.契波那契数列;

public class ClimbingStaris {
    /**
     * 题目描述：有 N 阶楼梯，每次可以上一阶或者两阶，求有多少种上楼梯的方法。
     * 定义一个数组 dp 存储上楼梯的方法数（为了方便讨论，数组下标从 1 开始），dp[i] 表示走到第 i 个楼梯的方法数目。
     * 第 i 个楼梯可以从第 i-1 和 i-2 个楼梯再走一步到达，走到第 i 个楼梯的方法数为走到第 i-1 和第 i-2 个楼梯的方法数之和。
     *
     *
     * 考虑到 dp[i] 只与 dp[i - 1] 和 dp[i - 2] 有关，因此可以只用两个变量来存储 dp[i - 1] 和 dp[i - 2]，使得原来的 O(N) 空间复杂度优化为 O(1) 复杂度。
     */
    public int climStirs(int stairs){
        if(stairs<=2){return stairs;}
        int pre2 = 1;//表示当前台阶前两个的台阶的走法
        int pre1 = 2;//表示当前台阶前一个的台阶的走法
        int res=0;//用来表示当前台阶的数目
        for(int i=3;i<=stairs;i++){
            res = pre1+pre2;//dp[i] = dp[i-1]+dp[i-2]
            pre2 = pre1;//下一个循环使用
            pre1 = res;//下一个循环使用
        }
        return res;
    }
}
