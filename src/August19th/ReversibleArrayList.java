package August19th;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class ReversibleArrayList<T> extends ArrayList<T> {
    public ReversibleArrayList(Collection<T> c){
        super(c);
    }

    /**
     * 适配器方法，当你有一个接口时，并需要另一个接口时，编写适配器就可以解决问题。
     * 选择向前或者向后迭代一个单词列表
     * @return
     */
    public Iterable<T> reversed(){
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size()-1;
                    @Override
                    public boolean hasNext() {
                        return current>-1;
                    }

                    @Override
                    public T next() {
                        return get(current--);
                    }
                };
            }
        };
    }
}
