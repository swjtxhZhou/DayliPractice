package thinkingInJava.part2.part6th;

import java.util.*;

public class SortedSetDemo {
    public static void main(String[] args){
        SortedSet<String> sortedSet = new TreeSet<>();
        Collections.addAll(sortedSet,"one two Three four five six seven eight".split(" "));
        System.out.println(sortedSet);

        String low = sortedSet.first();//容器的第一个元素
        String high = sortedSet.last();//容器的最后一个元素
        System.out.println("first: "+low+" last: "+high);

        Iterator<String> it = sortedSet.iterator();

        for(int i= 0; i<=6;i++){
            if(i  == 3) low = it.next();
            if(i==6) high = it.next();
            else it.next();
        }

        System.out.println("low :" +low+" high:"+high);
        System.out.println(sortedSet.subSet(low,high));
        System.out.println(sortedSet.headSet(low));//由小于low的元素组成
        System.out.println(sortedSet.tailSet(high));//由大于或等于high的元素组成

    }
}
