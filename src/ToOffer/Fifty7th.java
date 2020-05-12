package ToOffer;

import java.util.ArrayList;
import java.util.Arrays;

public class Fifty7th {
    /**
     * 和为 S 的两个数字
     * 使用双指针，一个指针指向元素较小的值，一个指针指向元素较大的值。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
     *
     * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
     * 如果 sum > target，移动较大的元素，使 sum 变小一些；
     * 如果 sum < target，移动较小的元素，使 sum 变大一些。
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int small=0;
        int big=array.length-1;
        while(small<big){
            if(array[small]+array[big]==sum){
                return new ArrayList<>(Arrays.asList(array[small],array[big]));
            }
            if(array[small]+array[big]<sum){
                small++;
            }else{
                big++;
            }
        }
        //如果没有匹配到返回一个空的ArrayList
        return new ArrayList<>();
    }
}
