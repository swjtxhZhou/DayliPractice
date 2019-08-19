package August19th;

import common.Pets;
import common.pets.Pet;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * 要实现一个不是Collection的外部类时，由于让它去实现Collection接口可能非常困难或者麻烦，
 * 可以通过继承AbstractCollection而很容易地实现
 * 但是无论如何还是要被强制实现iterator()和size()方法，以便提供AbstractCollection没有实现，但是AbstractCollection中的其他方法会用到；
 */
public class CollectionSequence extends AbstractCollection<Pet> {
    private Pet[] pets = Pets.createArray(8);
    public int size(){
        return pets.length;
    }
    public Iterator<Pet> iterator(){
        return new Iterator<Pet>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }
            public void remove(){//未实现该方法
                throw new UnsupportedOperationException();
            }
        };
    }
    public static void main(String[] args){
        CollectionSequence c = new CollectionSequence();
        InterfaceVSIterator.display(c);
        InterfaceVSIterator.display(c.iterator());
    }
}
