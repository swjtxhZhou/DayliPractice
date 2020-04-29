package ToOffer;

import java.util.ArrayList;
import java.util.Arrays;

public class Thirty8th_practice {
    private ArrayList<String> ret = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if(str.length() == 0){
            return ret;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        boolean[] hasUsed = new boolean[chars.length];
        backTracking(chars,hasUsed,new StringBuilder());
        return ret;
    }
    public void backTracking(char[] chars,boolean[] hasUsed,StringBuilder s){
        if(s.length() == chars.length){//当StringBuilder中字符的个数已经达到了原始字符的个数就可以将该字符串加入到结果中，然后返回上一级
            ret.add(s.toString());
            return;
        }
        for(int i =0;i<chars.length;i++){
            if(hasUsed[i]){
                continue;
            }
            //如果不是第一个字符，且该字符与上一个字符相同，且上一个字符还没有用过？？？
            if(i!=0&&chars[i]==chars[i-1]&&!hasUsed[i-1]){
                continue;
            }
            s.append(chars[i]);
            hasUsed[i] = true;
            backTracking(chars,hasUsed,s);
            s.deleteCharAt(s.length()-1);
            hasUsed[i] = false;
        }
    }
}
