package ToOffer.practice;

public class To46 {
    /**
     * 给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。一个数字有多种翻译可能，例如 12258 一共有 5 种，分别是 abbeh，lbeh，aveh，abyh，lyh。实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     * 使用动态规划来做
     * 新添加一位数字可以根据前一位数字的大小来判断新的长度的情况，并且依赖于上一个状态
     * 特殊情况，前一个数字是0那么当前情况还需要判断前两位数字是否大于26，如果大于，那么就没有解码的情况
     * 如果前面一个数字不是0，那么至少当前情况是和上一种状态是相同的
     * 如果前面两个数字小于26，那么还可以加上上种状态的解法
     *
     * dp[i] = dp[i]+dp[i-1] pre1!=0
     * dp[i] = dp[i]+dp[i-2] pre2<=26
     */
    public int numDecodings(String s) {
        if(s==null||s.length()==0)return 0;
        int length = s.length();
        int[] dp = new int[length+1];
        dp[0] = 1;
        dp[1] = s.charAt(0)!='0'?1:0;
        for(int i=1;i<=length;i++){
            int one = Integer.valueOf(s.substring(i-1,i));
            if(one!=0){
                dp[i]+=dp[i-1];
            }
            int two = Integer.valueOf(s.substring(i-2,i));
            if(two<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[length];

    }

    public int numDecodings_own(String s){
        if(s==null||s.length()==0)return 0;
        int length = s.length();
        int[] dp = new int[length+1];
        //初始化动态基
        dp[0]=1;
        if(s.charAt(0)!='0'){
            dp[1]=1;
        }
        for(int i=2;i<length;i++){
            //新添加的一位不是0
            if(s.charAt(i)!=0){
                dp[i]+=dp[i-1];
            }
            if(s.charAt(i-1)==0){
                continue;
            }
            //判断最后两位是否大于26
            int two = Integer.valueOf(s.substring(i-1,i+1));

            if(two<=26){
                dp[i] +=dp[i-2];
            }

        }
        return dp[length];
    }

    //复制力扣上的优秀答案
    public int numDecodings_FromLeetcode(String s){
        if(s==null||s.length()==0)return 0;
        int length = s.length();
        int[] dp = new int[length];
        if(s.charAt(0)!='0'){
            dp[0] = 1;
        }else{
            return 0;
        }
        for(int i=1;i<length;i++){
            //如果前后两位是无法解析的状况。比如00，30，40等等
            if(s.charAt(i)=='0'&&(s.charAt(i-1)>='3' || s.charAt(i-1)=='0')){
                return 0;
            }else if(s.charAt(i)=='0'&&(s.charAt(i-1)=='1'||s.charAt(i-1)=='2')){
                //前后两位是10，或者20
                if(i>1){
                    dp[i] = dp[i-2];
                }else{
                    dp[i] = 1;
                }
            }else if((s.charAt(i)<='9'&&s.charAt(i)>='1'&&s.charAt(i-1)=='1')||(s.charAt(i-1)=='2'&&s.charAt(i)<='6'&&s.charAt(i)>='1')){
                //前后两位是11-19或者21-26
                if(i>1){
                    dp[i]=dp[i-1]+dp[i-2];
                }else{
                    dp[i] = dp[i-1]+1;
                }
            }else {
                //前后是大于26的但是可以拆分的 比如27-29等
                if (i > 1) {
                    dp[i] = dp[i - 1];
                }else{
                    dp[i] = 1;
                }
            }
        }
        return dp[length-1];
    }
    //力扣上的优秀答案
    public int numDecodings_leetcode(String s) {
        if ("0".equals(s) || s.charAt(0) == '0') {
            return 0;
        }
        //dp[i]表示到字符串s下标i处时最多有几种解码方式
        int[] dp = new int[s.length()];
        //动态方程
        if (s.charAt(0) != '0') {
            dp[0] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            //无法解析的情况
            if (s.charAt(i) == '0' && (s.charAt(i - 1) > '2' || s.charAt(i - 1) == '0')) {
                return 0;
                //当前后2位是10或20
            } else if (s.charAt(i) == '0' && (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')) {
                if (i > 1) {
                    dp[i] = dp[i - 2];
                } else {
                    dp[i] = 1;
                }
                //当前后2位是21-26或11-19
            } else if ((s.charAt(i - 1) == '2' && s.charAt(i) > '0' && s.charAt(i) <= '6') || (s.charAt(i - 1) == '1')) {
                if (i > 1) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }

}
