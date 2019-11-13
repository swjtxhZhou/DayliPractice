package Chapter17th.part2.part6th;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TypesForSets {
    /**
     * 使用了泛型定义是为了避免代码重复。
     * fill()方法可以接受任何类型的的Set，以及其相同类型的Class对象，它使用Class对象来发现并接受int参数的构造器，然后调用该构造器蒋元素添加到Set中
     * @param set
     * @param type
     * @param <T>
     * @return
     */
    static <T> Set<T> fill(Set<T> set,Class<T> type){
        try{
            for(int i=0;i<10;i++){
                set.add(type.getConstructor(int.class).newInstance(i));
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return set;
    }

    /**
     * test（）会调用fill（）方法三次，尝试在其中引入重复对象，
     * @param set
     * @param type
     * @param <T>
     */
    static <T> void test(Set<T> set,Class<T> type){
        fill(set,type);
        fill(set,type);
        fill(set,type);
        System.out.println(set);
    }
    public static void main(String[] args){
        /**
         * HashSet以某种神秘的顺序保存所有的元素，
         * LinkedHashSet按照元素插入顺序保存元素
         * TreeSet按照排序顺序维护元素（按照CompareTo（）的实现方式，这里维护的是降序）
         */

        test(new HashSet<HashType>(),HashType.class);
        test(new LinkedHashSet<HashType>(),HashType.class);
        test(new TreeSet<TreeType>(),TreeType.class);
/**
 * 尝试将没有恰当当地支持必须的操作的类型用于需要这些方法的Set
 * 对于没有重新定义hashCode（）方法的SetType和TreeType，放置到任何散列实现中都会产生重复值，这违反了Set的基本契约，这甚至不会有运行错误
 * 尝试zaiTreeSet中使用没有实现CompareTo的类型，将抛出一个异常
 */
        test(new HashSet<SetType>(),SetType.class);
        test(new HashSet<TreeType>(),TreeType.class);
        test(new LinkedHashSet<SetType>(),SetType.class);
        test(new LinkedHashSet<TreeType>(),TreeType.class);

        try{
            test(new TreeSet<SetType>(),SetType.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            test(new TreeSet<HashType>(),HashType.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}

class SetType{
    int i;
    public SetType(int n){
        i = n;
    }

    /**
     * 所有Set中存储的类必须具有equals（）方法，因此在基类中耶需要该方法。器等价性事基于int类型的i值确认的
     * @param o
     * @return
     */
    public boolean equals(Object o){
        return o instanceof SetType &&(i==((SetType)o).i);//前一个比较类型是否相同，第二个比较值是否相同
    }
    public String toString(){
        return Integer.toString(i);
    }
}

class HashType extends SetType{
    public HashType(int n){super(n);}

    /**
     * 添加了hashCode（）方法，该方法对于放置到Set的散列实现中的对象来说事必须的。
     * @return
     */
    public int hashCode(){return i;}
}

class TreeType extends SetType implements Comparable<TreeType>{
    public TreeType(int n){super(n);}

    /**
     *一个对象被用于任何种类的排序容器中，例如SortedSet（TreeSet是其实现）必须实现compareTo()这个接口
     * @param arg
     * @return
     */
    public int compareTo(TreeType arg){
        return (arg.i<i?-1:(arg.i==i?0:1));
    }
}
