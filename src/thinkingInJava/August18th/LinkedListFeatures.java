package thinkingInJava.August18th;

import thinkingInJava.common.Pets;
import thinkingInJava.common.pets.Hamster;
import thinkingInJava.common.pets.Pet;
import thinkingInJava.common.pets.Rat;


import java.util.LinkedList;

public class LinkedListFeatures {
    public static void main(String[] args){
        LinkedList<Pet> pets = new LinkedList<Pet>(Pets.arrayList(5));
        System.out.println(pets);
        System.out.println("pets.getFirst:"+pets.getFirst());
        System.out.println("pets.element:"+pets.element());
        System.out.println("pets.peek():"+pets.peek());
        System.out.println();
        System.out.println("pets.remove:"+pets.remove());
        System.out.println("pets.removeFirst:"+pets.removeFirst());
        System.out.println("pets.poll:"+pets.poll());
        System.out.println();
        System.out.println(pets);
        pets.addFirst(new Rat());
        System.out.println("pets after addFirst:"+pets);
        pets.offer(Pets.randomePet());
        System.out.println("pets after offer:"+pets);
        pets.add(Pets.randomePet());
        System.out.println("pets after add:"+pets);
        pets.addLast(new Hamster());
        System.out.println("pets after addLast:"+pets);
        System.out.println("pets after removeLast:"+pets.removeLast());
    }
}
