package ToOffer;

import java.util.ArrayList;

public class Fiftyth_2nd_practice {
    /**
     * 和为 S 的连续正数序列
     * 输出所有和为 S 的连续正数序列。
     *
     * 例如和为 100 的连续序列有：
     *
     * [9, 10, 11, 12, 13, 14, 15, 16]
     * [18, 19, 20, 21, 22]。
     */

    public ArrayList<ArrayList<Integer>> FindContinusSequence(int sum){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int start = 1;
        int end = 2;
        int curSum = 3;
        while(end<sum){
            if(curSum<sum){
                end++;
                curSum+=end;
            }else if(curSum>sum){
                curSum-=start;
                start++;
            }else{
                ArrayList<Integer> list=new ArrayList<>();
                for(int i=start;i<=end;i++){
                    list.add(i);
                }
                ret.add(list);
                curSum-=start;
                start++;
                end++;
                curSum+=end;
            }
        }
        return ret;
    }
}
