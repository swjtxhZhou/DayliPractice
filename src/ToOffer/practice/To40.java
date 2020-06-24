package ToOffer.practice;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class To40 {
    /**
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     * 思路，通过维护一个大小为k的大顶堆，来确定最小的K个数
     * 因为大顶堆的最顶部是所有节点的最大值
     * 注意创建大顶堆和小顶堆的构造器参数
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input.length==0||k==0||k>input.length)return list;
        //创建一个大小为K的大顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) ->o2-o1 ));
        for(int i=0;i<input.length;i++){
            priorityQueue.add(input[i]);
            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }
        return new ArrayList<>(priorityQueue);
    }
}
