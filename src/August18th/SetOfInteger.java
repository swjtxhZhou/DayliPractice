package August18th;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class SetOfInteger {
    public static void main(String[] args){
        Set<Integer> intSet = new LinkedHashSet<Integer>();
        Random rand = new Random(47);
        for(int i = 0;i<1000;i++){
            intSet.add(rand.nextInt(30));
        }
        System.out.println(intSet);
    }
}
