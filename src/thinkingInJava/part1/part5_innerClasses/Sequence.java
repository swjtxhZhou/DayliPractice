package thinkingInJava.part1.part5_innerClasses;

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
        try {
            for (int i = 0; i < 20; i++) {//加入过多的元素
                sequence.add(Integer.toString(i));
            }
        }catch (ArrayIndexOutOfBoundsException e){//捕获了异常，接下来的代码仍会运行
            e.printStackTrace(System.out);
        }
        Selector selector=sequence.selector();
        while(!selector.end()){
            System.out.println(selector.current()+" ");
            selector.next();
        }
    }

}
