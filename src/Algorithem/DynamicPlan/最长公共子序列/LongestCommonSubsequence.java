package Algorithem.DynamicPlan.最长公共子序列;

public class LongestCommonSubsequence {
    /**
     * 最长公共子序列
     *给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
     * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
     *
     * 若这两个字符串没有公共子序列，则返回 0。
     * 对于0位置未添加空字符串
     * dp[i][j]表示的是s1[0...i−1]与s2[0...j−1]的最长公共子序列的长度,要求的是dp[m-1][n-1]
     * 当s1[i]==s2[j],说明这两个字符是公共的字符，只要考察其子问题，dp[i−1][j−1]的长度即可，在此基础上+1,
     * s1[i]!=s2[j],说明这两个字符不是公共的字符，只要考察其两个子问题，dp[i−1][j],dp[i][j−1],取max
     */
    public int longestCommonSubsequence(String str1,String str2){
        if(str1==null||str2==null||str1.length()==0||str2.length()==0)return 0;
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];//最初状态不用初始化了
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
