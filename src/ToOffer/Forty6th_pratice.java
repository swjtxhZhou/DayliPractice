package ToOffer;

public class Forty6th_pratice {
    public int numDecoding(String s){
        if(s==null||s.length()==0){//先判空，在判断字符串的长度
            return 0;
        }
        int n = s.length();
        int[] dp=new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0)=='0'?0:1;
        for(int i=2;i<=n;i++){
            int one = Integer.valueOf(s.substring(i-1,i));
            if(one!=0){
                dp[i] += dp[i-1];
            }
            if(s.charAt(i-2)=='0'){
                continue;
            }
            int two = Integer.valueOf(s.substring(i-2,i));
            if(two<=26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
