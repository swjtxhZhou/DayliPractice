package ToOffer;

public class Fourteen_practice {
    //贪心
    public int IntegerBreak(int n){
        if(n <= 2){return 1;}
        if(n==3)return 2;
        if(n==4)return 4;
        int timesOf3 = n / 3;
        if(n-timesOf3*3 == 1) {
            timesOf3--;
        }
        int timesOf2 = (n-timesOf3*3)/2;
        return (int)Math.pow(3,timesOf3)*(int)Math.pow(2,timesOf2);
    }

    //动态规划
    public int IntegerBreak1(int n){
        int[] dp=new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                int value1=j*(i-j);
                int value2=dp[j]*(i-j);
                dp[i]=Math.max(dp[i],Math.max(j*(i-j),dp[j]*(i-j)));
            }
        }
        return dp[n];
    }
}
