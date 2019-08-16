package August14th;

import common.Pets;
import common.pets.Pet;

import java.util.*;

public class CrossContainerIteration {
    public static void display(Iterator<Pet> it){
        while(it.hasNext()){
            Pet p = it.next();
            System.out.println(p.id()+":"+p+" ");
        }
        System.out.println();
    }

    /**
     * Iterator能够将遍历序列的操作与序列底层的结构分离。迭代器统一了对容器的访问方式
     * @param args
     */
    public static void main(String[] args){
        ArrayList<Pet> pets = Pets.arrayList(8);
        LinkedList<Pet> petsLL = new LinkedList<Pet>(pets);
        HashSet<Pet> petHS = new HashSet<Pet>(pets);
        TreeSet<Pet> petTS = new TreeSet<Pet>(pets);
        display(pets.iterator());
        display(petsLL.iterator());
        display(petHS.iterator());
        display(petTS.iterator());
    }
}
