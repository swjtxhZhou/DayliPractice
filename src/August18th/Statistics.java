package August18th;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Statistics {
    public static void main(String[] args){
        Random rand = new Random(47);
        Map<Integer,Integer> m = new HashMap<Integer, Integer>();
        for(int i =0 ; i<10000;i++){
            int r = rand.nextInt(20);
            Integer freq = m.get(r);
            /**
             * 第一个值为健，第二个值为值
             */
            m.put(r,freq == null ? 1 : freq+1);
        }
    }
}
