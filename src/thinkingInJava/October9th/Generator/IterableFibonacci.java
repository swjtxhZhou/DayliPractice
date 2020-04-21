package thinkingInJava.October9th.Generator;

import java.util.Iterator;

public class IterableFibonacci extends Fibonacci implements Iterable<Integer>{
    private int n;
    public IterableFibonacci(int count){
        n = count;
    }
    public Iterator<Integer> iterator(){
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
                /**
                 * "类名.this"是指"类名"的对象(一般在匿名类或内部类中使用来调用外部类的方法或属性)
                 * 由于IterableFibonacci继承了Fibonacci，所以含有next（）方法
                 */
            }
        };
    }
    public static void main(String[] args){
        for(int i:new IterableFibonacci(18)){
            System.out.println(i);
        }
    }
}
