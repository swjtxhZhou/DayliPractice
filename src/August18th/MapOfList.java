package August18th;

import common.*;
import common.pets.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapOfList {
        public static Map<Person, List<? extends Pet>> petPeople = new HashMap<Person, List<? extends Pet>>();
        static{
            petPeople.put(new Person("Dawn"), Arrays.asList(new Cymric("Molly"),new Mutt("Spot")));
            petPeople.put(new Person("Kate"),Arrays.asList(new Cat("shackleton"),new Cat("Elsie"),new Dog("Margrett")));

        }
        public static void main(String[] args){
            System.out.println("People:"+petPeople.keySet());
            System.out.println("Pets:"+petPeople.values());
            for(Person p:petPeople.keySet()){
                System.out.println(p+"has:");
                for(Pet pet:petPeople.get(p)){
                    System.out.println(" "+pet);
                }
            }

        }


}
