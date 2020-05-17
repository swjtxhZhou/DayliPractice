package Algorithem.DynamicPlan.分割整数;

public class DecodeWays {
    /**
     * 分割整数构成字母字符串
     * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * 示例 1:输入: "12"输出: 2
     * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
     * 示例 2 输入: "226"输出: 3
     * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
     *要观察最后两位的大小
     */
    public int numDecodings(String s){
        if(s==null||s.length()==0){
            return 0;
        }
        int n = s.length();
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=s.charAt(0)=='0'?0:1;
        for(int i=2;i<=n;i++){
            //判断最后一位是不是0，如果不是0，那么就至少等于dp[i-1]
            int one = Integer.valueOf(s.substring(i-1,i));//这里不用charAt是不是因为使用valueof（）方法得到的是字符串的ascii码值？？
            //valueof()只会接受string或者int参数
            if(one!=0){
                dp[i]+=dp[i-1];
            }
            if(s.charAt(i-2)=='0'){
                //如果倒数第二个值为0，的话就直接跳过
                continue;
            }
            int two = Integer.valueOf(s.substring(i-2,i));
            if(two<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[n];//这里并不是表示
    }

}
