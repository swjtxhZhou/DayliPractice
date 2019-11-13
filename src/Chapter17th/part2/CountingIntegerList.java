package Chapter17th.part2;

import java.util.AbstractList;
import java.util.AbstractSet;

/**
 * 从AbstractList创建只读的list，必须实现get（），和size（）；当寻找值时，get()将产生它
 */
public class CountingIntegerList extends AbstractList<Integer> {
    private int size;
    public CountingIntegerList(int size){
        this.size = size<0?0:size;
    }
    public Integer get(int index){
        return Integer.valueOf(index);
    }
    public int size(){
        return size;
    }
    public static void main(String[] args){
        System.out.println(new CountingIntegerList(30));
    }

}
