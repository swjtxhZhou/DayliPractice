package August9th.Collections;

import August7th.part1.part5_innerClasses.DotThis;

import java.util.*;

public class AddingGroups {
    public static void main(String[] args){
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
        Integer[] moreInts = {7,8,9,10};
        collection.addAll(Arrays.asList(moreInts));
        Collections.addAll(collection,11,12,13,14,15);
        Collections.addAll(collection,moreInts);
        List<Integer> list = Arrays.asList(16,17,18,19,20);
        /**
         * 改变了一个元素
         */
        list.set(1,99);
        //list.add(21);//操作失败，因为使用了asList,其底层表示的是数组，因此不能调整尺寸，用add()或者delete()会在运行时报错
    }
}
