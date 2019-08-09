package August7th.part1.part5_innerClasses;

public class Sequence {
    private Object[] items;
    private int next = 0;
    public Sequence(int size){
        items = new Object[size];
    }
    public void add(Object x){
        items[next++] = x;
    }

    /**
     * 内部类
     */
    private class SequenceSelector implements Selector{
        private int i=0;
        public boolean end(){
            return i==items.length;//内部类访问外部类的任意元素
        }
        public Object current(){
            return items[i];
        }
        public void next(){
            if(i<items.length) i++;
        }
    }
    public Selector selector(){
        return new SequenceSelector();
    }
    public static void main(String[] args){
        Sequence sequence= new Sequence(10);
        for(int i=0;i<10;i++){
            sequence.add(Integer.toString(i));
        }
        Selector selector=sequence.selector();
        while(!selector.end()){
            System.out.println(selector.current()+" ");
            selector.next();
        }
    }

}
