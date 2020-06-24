package ToOffer.practice;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class To59 {
    /**
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     * 考察点：数组，最大值，滑动窗口
     * 思路：因为滑动窗口里的元素是变化的，所以下一个窗口不能利用上一个窗口的信息
     * 常规做法：让滑动窗口从前往后遍历，每次比较窗口内的最大值
     * 优化方案：使用大顶堆来简化找窗口的最大值的过程
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if(num==null||num.length==0||size<=0)return list;
        int low =0,high=size-1;
        while(high<num.length){
            int max=Integer.MIN_VALUE;
            for(int i=low;i<=high;i++){
               max = Math.max(max,num[i]);
            }
            list.add(max);
            low++;
            high++;
        }
        return list;
    }
    //使用大顶堆来找最大值的方案
    public ArrayList<Integer> maxInWindows_priorityQueue(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if(num==null||num.length==0||size<=0||size>num.length)return list;
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2-o1));
        for(int i=0;i<size;i++){
            queue.add(num[i]);
        }
        list.add(queue.peek());
        for(int i=0,j=size;j<num.length;i++,j++){
            queue.remove(num[i]);
            queue.add(num[j]);
            list.add(queue.peek());
        }
        return list;
    }
}
