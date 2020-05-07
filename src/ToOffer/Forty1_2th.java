package ToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Forty1_2th {
    /**
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。
     * 当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
     */
    /**
     * 肯定要一个变量来存这个第一个只出现一次的字符，这个变量的值会变
     * 还要一个list来存储已经出现过两次的字符
     * 还有一个list来存储已经出现过一次的字符，但是不是第一个
     * 怎么改变这个变量喃？
     */
    char firstAppear;
    ArrayList<Character> moreThan2 = new ArrayList<>();
    ArrayList<Character> justOnce = new ArrayList<>();

    public void Insert(char ch) {
        if(!moreThan2.contains(ch)){
           if(!justOnce.contains(ch) ){
               FirstAppearingOnce(ch);
           }else{
               justOnce.remove(ch);
               moreThan2.add(ch);
           }
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(char ch) {
        if(ch==firstAppear){
            moreThan2.add(ch);
            if(!justOnce.isEmpty()) {
                firstAppear = justOnce.get(0);
                justOnce.remove(firstAppear);
            }else{
                firstAppear = '#';
            }
        }else{
            justOnce.add(ch);
        }
        return firstAppear;
    }

    private int[] cnts = new int[256];
    private Queue<Character> queue = new LinkedList<>();//队列，先入队的先出去

    public void Insert1(char ch) {
        cnts[ch]++;//每个字符代表的数字从0开始往上加，每出现一次就加一次
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1)//队列不为空，队列顶部对应的字符出现的次数超过一次就把他弹出来
            queue.poll();//队列里面第一个字符绝对是只出现过一次的
    }

    public char FirstAppearingOnce1() {
        return queue.isEmpty() ? '#' : queue.peek();//队列为空返回#，不为空将第一个推出去
    }
}
