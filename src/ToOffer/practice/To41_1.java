package ToOffer.practice;

import java.util.PriorityQueue;

public class To41_1 {
    /**
     * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
     *思路：维护一个大顶堆和一个小顶堆，大顶堆储存前一半的数据，小顶堆储存后一半的数据
     * 如果是奇数，就取大顶堆的第一个元素
     * 如果是偶数，就取大顶堆和小顶堆的堆顶元素求其平均
     *
     * 做的过程中出现了一个错误的思想，就是不分大小的分别往两个堆里加入元素，没有使大顶堆和小顶堆一起作用来维护整个序列的有序性。
     */
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2-o1));
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();//优先队列默认就是小顶堆，升序
    private int N =0;//记录加入到堆中的数据个数
    public void Insert(Integer num) {
        if(N%2==0){
            //现在加入的是奇数个，先加入到小顶堆中，然后将小顶堆的堆顶元素poll到大顶堆中
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }else{
            //现在加入的是偶数个，先加入到大顶堆中，然后将大顶堆的堆顶元素poll到小顶堆中
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
        N++;
    }

    public Double GetMedian() {
        //如果两个堆的数量之和为奇数
        int cnt = minHeap.size()+maxHeap.size();
        if(cnt%2==1){
            double res = maxHeap.peek();
            return res;
        }else{
            double res = maxHeap.peek()+minHeap.peek();
            return res/2;
        }
    }
}
