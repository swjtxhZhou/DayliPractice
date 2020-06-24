package ToOffer.practice;

public class To49_specialDynamicPlan {
    /**
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     * 解题思路，利用动态规划
     * 因为丑数的因子只会是2，3，5，而下一个丑数一定是前面的某一个丑数乘以2，3，5其中一个。所有用i2,i3,i5来维护前面一个需要乘的丑数。而由于不知道前一个丑数是哪一个和当前需要承的因子又是哪一个所以需要动态方程
     * dp[i]=Math.min(dp[i2]*2,Math.min(dp[i3]*3,dp[i5]*5))
     */
    public int GetUglyNumber_Solution(int index) {
        if(index<=6)return index;
        int[] dp = new int[index];
        int i2=0,i3=0,i5=0;
        //初始化初始基
        dp[0] = 1;
        for(int i=1;i<index;i++){
            int next2 = dp[i2]*2;
            int next3 = dp[i3]*3;
            int next5 = dp[i5]*5;
            dp[i] = Math.min(next2,Math.min(next3,next5));
            //这里不能使用else if,因为next2、next3、next5可能出现相同，那么对应的i2、i3、i5要同时改变，
            if(dp[i]==next2){
                i2++;
            }
            if(dp[i]==next3){
                i3++;
            }
            if(dp[i]==next5){
                i5++;
            }
        }
        return dp[index-1];
    }
    public static void main(String[] args){
        To49_specialDynamicPlan to49 = new To49_specialDynamicPlan();
        int num = to49.GetUglyNumber_Solution(7);
        System.out.println(num);
    }
}
