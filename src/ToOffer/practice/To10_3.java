package ToOffer.practice;

public class To10_3 {
    /**
     * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * 找初始基：当n=1时有一种跳法，当n=2时有两种跳法
     * 动态更新方程，当n>=3时，第一步跳一阶，那么剩下的n-1步的跳法需要知道，第一步跳二阶，剩下的n-2步的跳法也是已知的，f(n)=f（n-1）+f(n-2)
     *一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     */
    public int JumpFloor(int target) {
        if(target<=2)return target;
        int pre1=2,pre2=1;
        int result = 0;
        for(int i=3;i<=target;i++){
            result = pre1+pre2;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

}
