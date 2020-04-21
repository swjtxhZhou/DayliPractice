package thinkingInJava.August19th;

import thinkingInJava.common.Pets;
import thinkingInJava.common.pets.Pet;

import java.util.*;

public class InterfaceVSIterator {
    public static void display(Iterator<Pet> it){
        while(it.hasNext()){
            Pet p = it.next();
            System.out.println("id:"+p.id()+" p:"+p);
        }
        System.out.println();
    }
    public static void display(Collection<Pet> pets){
        for(Pet p:pets){
            System.out.println("id:"+p.id()+" p:"+p);
        }
        System.out.println();
    }
    public static void main(String[] args){
        List<Pet> petList= Pets.arrayList(8);
        Set<Pet> petSet = new HashSet<Pet>(petList);
        Map<String, Pet> petMap = new LinkedHashMap<String, Pet>();
        String[] names= ("Ralph, Eric, Robin, Lacey, "+"Britney, Sam, Spot, Fluffy").split(", ");
        for(int i = 0;i<names.length;i++){
            petMap.put(names[i],petList.get(i));
        }
        /**
         * 接口描述
         */
        display(petList);
        display(petSet);
        /**
         * 迭代器形式
         */
        display(petList.iterator());
        display(petSet.iterator());
        System.out.println(petMap);
        System.out.println(petMap.keySet());
        display(petMap.values());
        display(petMap.values().iterator());
    }
}
