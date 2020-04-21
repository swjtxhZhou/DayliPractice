package thinkingInJava.August19th;

import thinkingInJava.August18th.QueueDemo;

import java.util.*;

/**
 * Integet String Character可以与PriorityQueue一起工作，因为这些类内建了自然排序。如果想使用自己的类。就必须包括额外的功能以产生自然排序。或者必须提供自己的Comparator
 */
public class PriorityQueueDemo {
    public static void main(String[] args){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        Random rand = new Random(47);
        for(int i = 0; i<10;i++){
            priorityQueue.offer(rand.nextInt(i+10));
        }
        QueueDemo.printQ(priorityQueue);
        List<Integer> ints = Arrays.asList(25,22,28,18,14,9,3,1,1,2,3,9,14,18,21,23,25);
        priorityQueue = new PriorityQueue<Integer>(ints);
        QueueDemo.printQ(priorityQueue);
        /**
         * 调用了Collections.reverseOrder()产生的反序的Comparator
         */
        priorityQueue = new PriorityQueue<Integer>(ints.size(), Collections.reverseOrder());
        priorityQueue.addAll(ints);
        QueueDemo.printQ(priorityQueue);

        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPQ= new PriorityQueue<String>(strings);
        QueueDemo.printQ(stringPQ);
        stringPQ = new PriorityQueue<String>(strings.size(),Collections.reverseOrder());
        stringPQ.addAll(strings);
        QueueDemo.printQ(stringPQ);
        /**
         * HashSet消除重复的Character
         */
        Set<Character> charSet = new HashSet<Character>();
        for(char c:fact.toCharArray()){
            charSet.add(c);
        }
        PriorityQueue<Character> characterPQ= new PriorityQueue<Character>(charSet);
        QueueDemo.printQ(characterPQ);
    }
}



