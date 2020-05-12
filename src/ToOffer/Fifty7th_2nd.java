package ToOffer;

import java.util.ArrayList;

public class Fifty7th_2nd {
    /**
     * 和为 S 的连续正数序列
     * 输出所有和为 S 的连续正数序列。
     *
     * 例如和为 100 的连续序列有：
     *
     * [9, 10, 11, 12, 13, 14, 15, 16]
     * [18, 19, 20, 21, 22]。
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();//用来保存连续序列
        //用两个指针来维护最前面的数字和最后面的数字
        int start = 1, end = 2;
        //这个是当前连续序列之和
        int curSum = 3;
        while (end < sum) {
            if (curSum > sum) {
                //加到当前序列大于总和，需要把最小的数减去，最前面的数变为第二小的数
                curSum -= start;
                start++;
            } else if (curSum < sum) {
                //如果当前序列小于总和，把末尾的数的后面一个数加到序列中
                end++;
                curSum += end;
            } else {//当前序列等于总和
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++)
                    list.add(i);
                ret.add(list);
                //接下来是将其他的可能全部考虑进去
                //这样又会开始重新找，但是开始位置变得不一样了，所以找到的序列也是不一样的。
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return ret;
    }
}
