package August14th;

import common.Pets;
import common.pets.Pet;

import java.util.List;
import java.util.ListIterator;

/**
 * ListIterator可以双向移动。它还可以产生相对于迭代器在列表中指向的当前位置的前一个和后一个元素的索引，并且可以使用set（）方法替换它访问过的最后元素。
 *
 */
public class ListIteration {
    public static void main(String[] args){
        List<Pet> pets = Pets.arrayList(8);
        ListIterator<Pet> it = pets.listIterator();
        while(it.hasNext()){
            System.out.println(it.next()+","+it.nextIndex()+","+it.previousIndex()+";");
        }
        System.out.println();
        /**
         * 往头部移动
         */
        while(it.hasPrevious()){
            System.out.println(it.previous().id()+" ");
        }
        System.out.println();
        System.out.println(pets);
        /**
         * Pet.randomPet(3)方法用来替换在列表中从位置3开始向前的所有Pet对象
         */
        it = pets.listIterator(3);
        while(it.hasNext()){
            it.next();
            it.set(Pets.randomePet());
        }
        System.out.println(pets);
    }
}
