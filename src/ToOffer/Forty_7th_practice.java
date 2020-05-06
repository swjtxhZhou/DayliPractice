package ToOffer;

public class Forty_7th_practice {
    public int FindMostValue(int[][] values){
        if(values==null||values.length==0||values[0].length==0){
            return 0;
        }
        int n = values.length;//行数
        int[] dp = new int[n];
        for(int[] value:values){
            dp[0] += value[0];
            for(int i=1;i<n;i++){
                dp[i] = Math.max(dp[i],dp[i-1])+value[i];
            }
        }
        return dp[n-1];
    }
}
