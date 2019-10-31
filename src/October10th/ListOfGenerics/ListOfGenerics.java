package October10th.ListOfGenerics;

import java.util.ArrayList;
import java.util.List;
//在任何想要创建泛型数组的地方都是用ArrayList（）
public class ListOfGenerics<T> {
    private List<T> array = new ArrayList<T>();
    public void add(T item){
        array.add(item);
    }
    public T get(int index){
        return array.get(index);
    }
}
