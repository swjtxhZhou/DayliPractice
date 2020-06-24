package ToOffer.practice;

import java.util.ArrayList;

public class To57_1 {
    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     * 对应每个测试案例，输出两个数，小的先输出。
     * 考察点：数组
     * 目标对象是两个元素，目标结果两个对象之后为S，两个对象的乘积最小
     * 想法：
     * 1、如果有多个元素组符合，找两者的差是最大的就是乘积最小的那一组
     * 2、两个元素就需要两个指针，一个从头出发，一个从末尾出发
     * 如果相加的和大于目标值就让末尾的指针往前走
     * 如果相加的和小于目标值就让头部的指针往后走
     * 这样遇到的第一对元素组也是乘积最小的，不能再额外判断
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(array==null||array.length==0){
            return list;
        }
        int low = 0,high = array.length-1;
        while(low<high){
            if(array[low]+array[high]==sum){
                list.add(array[low]);
                list.add(array[high]);
                return list;
            }else if(array[low]+array[high]<sum){
                low++;
            }else if(array[low]+array[high]>sum){
                high--;
            }
        }
        return list;
    }
}
