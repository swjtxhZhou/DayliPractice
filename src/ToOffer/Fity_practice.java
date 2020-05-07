package ToOffer;

import java.util.BitSet;

public class Fity_practice {
    public int FirstNotRepeatingChar(String str){
        if(str==null||str.length()==0)return 0;
        int[] cnt = new int[256];
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            cnt[c]++;
        }
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(cnt[c]==1)return i;
        }
        return 0;
    }

    public int FirstNotRepeatingChar2(String str){
        if(str==null||str.length()==0)return 0;
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(!bs1.get(c)&&!bs2.get(c)){
                bs1.set(c);
            }else if(bs1.get(c)&&!bs2.get(c)){
                bs2.set(c);
            }
        }
        for(int i=0;i<str.length();i++){
            if(bs1.get(str.charAt(i))&&!bs2.get(str.charAt(i))){
                return i;
            }
        }
        return 0;
    }
}
