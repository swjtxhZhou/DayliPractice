package ToOffer;

import java.util.LinkedList;
import java.util.Queue;

public class Forty1_2th_practice {
    int[] cnts = new int[256];
    Queue<Character> queue = new LinkedList<>();

    public void Insert(char ch){
        cnts[ch]++;
        queue.add(ch);
        while(!queue.isEmpty()&&cnts[queue.peek()]>1){
            queue.poll();
        }
    }
    public char FirstAppearingOnce(){
        return queue.isEmpty()?'#':queue.peek();
    }
}
