package thinkingInJava.August19th;

import thinkingInJava.common.pets.Pet;

import java.util.Iterator;

/**
 * 实现Collection,就必须实现iterator().
 * 若你的类已经继承了其他的类，那么你就不能在继承AbstractCollection。
 * 这种情况下，要实现Collection就必须实现该接口的所有方法。
 */
public class NonCollectionSequence extends PetSequence{
    /**
     * 生成Iterator是将队列与消费队列方法连接在一起耦合度最小的方式
     * @return
     */
    public Iterator<Pet> iterator(){
        return new Iterator<Pet>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index<pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
    public static void main(String[] args){
        NonCollectionSequence nc = new NonCollectionSequence();
        InterfaceVSIterator.display(nc.iterator());
    }
}
