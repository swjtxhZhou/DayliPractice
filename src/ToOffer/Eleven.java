package ToOffer;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Eleven {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 非递减排序，要么相等要么递增
     */
    //暴力寻找法
    public int minNumberInRotateArray(int[] array){
        if(array.length==0){
            return 0;
        }
        //在两段范围内都是非降序，当不符合这个规律时，就找到了最小数字
        for(int i=0;i<array.length-1;i++){
            if(array[i] > array[i+1]){//若前一个数比后一个数更大，说明天后一个数就是最小值
                return array[i+1];
            }
        }
        //如果没有找到，说明数组的数字是一样大的，直接返回任何一个数值
        return array[0];
    }
    //利用已有的工具进行排序,缺点是会改变原始数组的顺序
    public int minNumberInRotateArray2(int[] array){
        if(array.length ==0){return 0;}
        Arrays.sort(array);
        return array[0];
    }
    //利用优先队列,将数组元素挨着丢进优先队列，优先队列默认为最小堆，弹出的第一个数就是整个数组的最小值
    //默认的优先队列是把最小的排在最前面，可以直接重写CompareTo函数，实现自己需要的优先队列
    public int minNumberInRotateArray3(int[] array){
        if(array.length == 0){
            return 0;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i=0;i<array.length;i++){
            priorityQueue.add(array[i]);
        }
        return priorityQueue.poll();
    }
}
