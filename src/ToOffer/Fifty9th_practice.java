package ToOffer;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Fifty9th_practice {
    public ArrayList<Integer> maxInWindows(int[] nums,int size){
        //保存结果
        ArrayList<Integer> ret = new ArrayList<>();
        if(size>nums.length||size<1)return ret;
        //生成大顶堆
        PriorityQueue<Integer> Maxheap = new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int i=0;i<size;i++){
            Maxheap.add(nums[i]);
        }
        ret.add(Maxheap.peek());//大顶堆的头部是元素中最大的
        for(int i=0,j=i+size;j<nums.length;i++,j++){
            Maxheap.remove(nums[i]);
            Maxheap.add(nums[j]);
            ret.add(Maxheap.peek());
        }
        return ret;
    }
}
