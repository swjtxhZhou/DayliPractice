package ToOffer;

public class Forty9th_practice {
    public int GetUglyNumber(int index){
        if(index<=6){return index;}
        int[] dp = new int[index];
        int i2=0,i3=0,i5=0;//i2,i3,i5维护每一个丑数的内在因子2，3，5的数量
        dp[0]=1;//第一个丑数为0；
        /**
         * 1 2=1*2 3=1*3 4=2*2 5=1*5 6=2*3 8=4*2 9=6*3 10=2*5.。。。。。
         * 所以我们要维持三个指针来记录当前乘以2、乘以3、乘以5的最小值，然后当其被选为新的最小值后，要把相应的指针+1；
         * 因为这个指针会逐渐遍历整个数组，因此最终数组中的每一个值都会被乘以2、乘以3、乘以5，
         */
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
