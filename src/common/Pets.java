package common;

import common.pets.Pet;

import java.util.ArrayList;

public class Pets {
    public static final PetsCreator creator = new LiteralPetCreator();
    public static Pet randomePet(){
        return creator.randomPet();
    }
    public static Pet[] createArray(int size){
        return creator.createArray(size);
    }
    public static ArrayList<Pet> arrayList(int size){
        return creator.arrayList(size);
    }
}
