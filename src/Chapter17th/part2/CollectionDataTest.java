package Chapter17th.part2;

import October9th.Generator.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

public class CollectionDataTest {
    public static void main(String[] args){
        /**
         * 所有的Collection子类型都有一个接收另一个Collection的构造器，用所接收的对象中的元素来填充新的容器
         */
        Set<String> set = new LinkedHashSet<>(new CollectionData<String>(new Government(),15));
        /**
         * collection这个类使用Generator在容器中放置所需数量的对象，然后所产生的容器可以传递给任何Collection的构造器，这个构造器会把其中的数据复制到自身中
         * addALL()方法是所有Collection子类型的一部分，他也可以用来组装现有的Collection。
         */
//        set.addAll(CollectionData.list(new Government(),15));
        System.out.println(set);
    }
}

class Government implements Generator<String>{
    String[] foundation = ("strange women lying in pounds"+" disturbing swords is no basis for a system of"+" government").split(" ");
    private int index;
    public String next(){
        return foundation[index++];
    }
}
