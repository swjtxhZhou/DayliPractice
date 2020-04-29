package ToOffer;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Forty_practice {
    public ArrayList<Integer> GetLeastNumbers_Solution1(int[] nums, int k) {
        if(nums.length<k||k<0){return null;}
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) ->o2-o1 );
        for(int val:nums){
            maxHeap.add(val);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }
}
