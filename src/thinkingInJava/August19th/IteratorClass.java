package thinkingInJava.August19th;

import java.util.Iterator;

public class IteratorClass implements Iterable<String>{
    protected String[] words = ("And that is how "+"we know the Earth to be banan-shaped").split(" ");
    public Iterator<String> iterator(){
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index<words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }

    /**
     * iterator()方法Iterator<String>的匿名内部类的实列，该匿名内部类可以遍历数组中的所有单词</>
     * @param args
     */
    public static void main(String[] args){
        for(String s:new IteratorClass()){
            System.out.println("S:"+s);
        }
    }
}
