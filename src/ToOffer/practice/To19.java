package ToOffer.practice;

public class To19 {
    /**
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     *
     */
    public boolean match(char[] str, char[] pattern){
        int m = str.length;
        int n = pattern.length;
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;//两者长度都是0，所以可以匹配成功
        //特殊情况，出现x*x*x*x*这种情况，x代表正常字符
        for(int i=1;i<=n;i++){
            if(pattern[i-1]=='*'){
                dp[0][i]=dp[0][i-2];
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str[i-1]==pattern[j-1]||pattern[j-1]=='.'){
                    /**
                     * (1)、两个数组的字符是相同的
                     * （2）、模式中的字符上一个是'.'所以可以匹配任何字符
                     */
                    dp[i][j]=dp[i-1][j-1];
                }else if(pattern[j-1]=='*'){
                    /**
                     * 模式中的上一个字符是‘*’
                     * （1）、模式中上上个字符是与匹配字符相同的
                     * （2）、模式中的上上个字符是'.'，可以任意匹配
                     * （3）、如果不满足上面两个要求，那么就有可能表示出现了零次
                     */
                    if(str[i-1]==pattern[j-2]||pattern[j-2]=='.'){
                        dp[i][j] |= dp[i][j-1];//只有一次
                        dp[i][j] |= dp[i-1][j];//会重复多次
                        dp[i][j] |= dp[i][j-2];//重复了零次
                    }else{
                        dp[i][j] = dp[i][j-2];//重复零次
                    }
                }
            }
        }
        return dp[m][n];

    }
}
