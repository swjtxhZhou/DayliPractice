package ToOffer;

public class TenTwo {
    /**
     * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * 当 n = 1 时，只有一种跳法：
     * 当 n = 2 时，有两种跳法：
     * 跳 n 阶台阶，可以先跳 1 阶台阶，再跳 n-1 阶台阶；或者先跳 2 阶台阶，再跳 n-2 阶台阶。而 n-1 和 n-2 阶台阶的跳法可以看成子问题，该问题的递推公式为：
     */
    public int JumpFloor(int n){
        if(n<=2)return  n;
        int result = 0;
        int pre1 = 2;//先跳一个台阶，剩下n-1个台阶
        int pre2 = 1;//先挑两个台阶，剩下n-2个台阶
        for(int i= 3;i<=n;i++){//(int i= 2;i<n;i++)其实是一样的
            result = pre1+pre2;
            pre1 = result;
            pre2 = pre1;
        }
        return result;
    }

}
