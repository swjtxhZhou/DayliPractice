package ToOffer.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class To45 {
    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     *
     * 拼最小的数字，
     * 一开始想的是通过贪心算法，比对所有数字的第一位的大小然后取最小值，如果第一位都是一样的，就比较第二位。但是这样做不能保证所有的数字字符串的长度是一样的，这样操作会非常麻烦
     *
     * 题解思路：
     * 可以看成是一个排序问题，在比较两个字符串 S1 和 S2 的大小时，应该比较的是 S1+S2 和 S2+S1 的大小，如果 S1+S2 < S2+S1，那么应该把 S1 排在前面，否则应该把 S2 排在前面。
     *
     */
    public String PrintMinNumber(int [] numbers) {
        if(numbers.length==0)return "";
        //把所有的数字存为一个字符数组
        String[] strings = new String[numbers.length];
        for(int i=0;i<numbers.length;i++) {
            strings[i] = numbers[i] + "";
        }
        Arrays.sort(strings,(s1,s2)->(s1+s2).compareTo(s2+s1));//这里是升序,sort()方法只会对数组类型进行排序。
        StringBuilder ret = new StringBuilder();
        for(String str:strings){
//            ret += str;
            ret.append(str);
        }
//        Arrays.sort(list);
        return new String(ret);

    }
}
