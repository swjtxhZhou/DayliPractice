package August18th;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetOperation {
    public static void main(String[] args){
        Set<String> set1 = new HashSet<String>();
        Collections.addAll(set1,"A B C D E F G".split(" "));
        set1.add("H");
        System.out.println("H:"+set1.contains("H"));
        System.out.println("J:"+set1.contains("J"));
        Set<String> set2 = new HashSet<String>();
        Collections.addAll(set2,"F G J K L M N".split(" "));
        System.out.println("set2 in set1:"+set1.containsAll(set2));
        set1.removeAll(set2);
        System.out.println("set2 removed from set1"+set1);


    }
}
