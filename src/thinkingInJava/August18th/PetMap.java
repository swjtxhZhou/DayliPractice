package thinkingInJava.August18th;

import thinkingInJava.common.pets.Cat;
import thinkingInJava.common.pets.Dog;
import thinkingInJava.common.pets.Hamster;
import thinkingInJava.common.pets.Pet;

import java.util.HashMap;
import java.util.Map;

public class PetMap {
    public static void main(String[] args){
        Map<String, Pet> petMap = new HashMap<String, Pet>();
        petMap.put("My cat",new Cat("Molly"));
        petMap.put("My dog",new Dog("Ginger"));
        petMap.put("My hamster",new Hamster("Bosco"));
        System.out.println(petMap);
        Pet dog = petMap.get("My dog");
        System.out.println(dog);
        System.out.println(petMap.containsKey("My cat"));
        System.out.println(petMap.containsValue(dog));
    }
}
