package ToOffer;

public class Forty9th_practice {
    public int GetUglyNumber(int index){
        if(index<=6){return index;}
        int[] dp = new int[index];
        int i2=0,i3=0,i5=0;
        dp[0]=1;//第一个丑数为0；
        for(int i=1;i<index;i++){
            int next2 = dp[i2]*2,next3 = dp[i3]*3,next5 = dp[i5]*5;
            dp[i] = Math.min(next2,Math.min(next3,next5));
            if(dp[i]==next2)i2++;
            if(dp[i]==next3)i3++;
            if(dp[i]==next5)i5++;
        }
        return dp[index-1];
    }
    public static void main(String[] args){
        int index = 8;
        Forty9th_practice forty9th_practice = new Forty9th_practice();
        int UglyNum=forty9th_practice.GetUglyNumber(index);
    }
}
