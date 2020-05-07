package ToOffer;

import java.util.Arrays;

public class Forty5th {
    /**
     * 把数组排成最小的数
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组 {3，32，321}，则打印出这三个数字能排成的最小数字为 321323。
     *
     * 巧用字符串拼接和Arrays.sort()这个方法
     */
    public String PrintMinNumber(int[] numbers){
        if(numbers.length==0||numbers==null)return "";
        String[] nums = new String[numbers.length];
        int i=0;
        for(int number:numbers){
            nums[i++] = number+"";
            Arrays.sort(nums,(o1,o2)->(o1+o2).compareTo(o2+o1));//通过字符串拼接来判断哪个字符应该在前面
        }
        String ret = "";
        for(String num:nums){
            ret += num;
        }
        return ret;
    }
}
