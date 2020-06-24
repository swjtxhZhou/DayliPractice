package ToOffer.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class To38 {
    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
     * 使用回溯
     * 这里要考虑字符重复的情况，
     * 在进行递归之前需要将字符串转换为字符数组，并将字符数组排序
     * 每一次递归里面都有迭代，使用额外的全局标志符来判断哪些字符是使用过的
     */
    ArrayList<String> ret = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if(str.length()==0)return ret;
        //把字符串转换为字符
        char[] s = str.toCharArray();
        Arrays.sort(s);
        print(s,new boolean[s.length],new StringBuilder());
        return ret;
    }

    public void print(char[] s,boolean[] hasUsed,StringBuilder stringBuilder){
        //递归最底层
        if(stringBuilder.length()==s.length){
            ret.add(new String(stringBuilder));
        }
        for(int i =0; i<s.length;i++){
            if(hasUsed[i])continue;
            if(i!=0&& s[i]==s[i-1]&&!hasUsed[i-1]){
                //该次的字符和上一个字符相同，并且，上一个字符已经使用过了
                continue;
            }
            //
            hasUsed[i] =true;
            stringBuilder.append(s[i]);
            print(s,hasUsed,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            hasUsed[i] = !hasUsed[i];
        }
    }
}
