package ToOffer.practice;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class To41_2 {
    /**
     * 题目描述
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
     * 如果当前字符流没有存在出现一次的字符，返回#字符。
     * 字符串问题
     * 使用占坑位的想法，用一个长的数组表示256个字符，
     * 使用队列来维护是否是第一个，如果队首的元素在cnt中的数量超过两个就把它弹出继续判断下一个元素。
     */
    int[] cnt = new int[256];//所有字符的ASCLL码的数量是0-255
    //注意队列的实现方式！！！
    Queue<Character> queue = new LinkedList<>();
    public void Insert(char ch) {
        cnt[ch]++;
        queue.add(ch);
        while(!queue.isEmpty()&&cnt[queue.peek()]>1){
            queue.poll();//队首 的元素出现的次数超过了两次，将其弹出
        }
    }

    public char FirstAppearingOnce() {
        if(!queue.isEmpty()){
            return queue.peek();
        }else{
            return '#';
        }
    }
}
