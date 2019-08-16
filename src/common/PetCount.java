package common;

import common.pets.*;

import java.util.HashMap;

/**
 * 为了对Pet计数。需要一个能够跟踪各种不同类型的Pet的数量的工具，Map是此需求的首选，其中键是pet类型名，而值是pet数量的Integer
 */
public class PetCount {
    static class PetCounter extends HashMap<String,Integer>{
        public void count(String type){
            Integer quantity = get(type);
            if(quantity == null){
                put(type,1);
            }else{
                put(type,quantity +1);
            }
        }
    }

    /**
     * 使用PetCreator来随机地向数组填充pet，然后使用instanof对该数组中的每个pet进行测试和计数
     * instanceof只能与命名类型进行比较，而不能与class对象作比较
     * @param petsCreator
     */
    public static void countPets(PetsCreator petsCreator){
        PetCounter petCounter = new PetCounter();
        for(Pet pet:petsCreator.arrayList(20)){
            System.out.println(pet.getClass().getSimpleName());
            if(pet instanceof Pet)
                 petCounter.count("Pet");
            if(pet instanceof Dog)
                petCounter.count("Dog");
            if(pet instanceof Mutt)
                petCounter.count("Mutt");
            if(pet instanceof Pug)
                petCounter.count("Pug");
            if(pet instanceof Cat)
                petCounter.count("Cat");
            if(pet instanceof EgyptianMau)
                petCounter.count("EgyptianMau");
            if(pet instanceof Manx)
                petCounter.count("Manx");
            if(pet instanceof Cymric)
                petCounter.count("Cymric");
            if(pet instanceof Rodent)
                petCounter.count("Rodent");
            if(pet instanceof Rat)
                petCounter.count("Rat");
            if(pet instanceof Mouse)
                petCounter.count("Mouse");
            if(pet instanceof Hamster)
                petCounter.count("Hamster");
        }
        System.out.println();
        System.out.println(petCounter);
    }
    public static void main(String[] args){
        countPets(new ForNameCreator());
    }
}
