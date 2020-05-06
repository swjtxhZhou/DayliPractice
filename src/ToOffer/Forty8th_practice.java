package ToOffer;

import java.util.Arrays;

public class Forty8th_practice {
    public int LongestSubstringWithoutDuplication(String s){
        if(s==null||s.length()==0){return 0;}
        int curLen=0;
        int maxLen = 0;
        int[] preIndexs = new int[26];//记录字符上一次出现的位置
        Arrays.fill(preIndexs,-1);
        for(int i=0;i<s.length();i++){
            int c = s.charAt(i)-'a';
            int pre = preIndexs[c];
            if(pre==-1||i-pre>curLen){
                curLen++;
            }else{
                maxLen = Math.max(curLen,maxLen);
                curLen = i-pre;
            }
            preIndexs[c] = i;
        }
        maxLen = Math.max(curLen,maxLen);
        return maxLen;
    }
}
