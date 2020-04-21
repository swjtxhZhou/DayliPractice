package thinkingInJava.common;

import thinkingInJava.common.pets.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LiteralPetCreator extends PetsCreator{
    @SuppressWarnings("unchecked")
    public static final List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(Arrays.asList(Pet.class, Dog.class, Cat.class, Rodent.class, Mutt.class,Pug.class,EgyptianMau.class,Manx.class,Cymric.class,Rat.class,Mouse.class,Hamster.class));
    /**
     * subList找到父集中的指定子集，第一个参数是开始序号，第二参数是结束序号
     */
    private static final List<Class<? extends Pet>> types = allTypes.subList(allTypes.indexOf(Mutt.class),allTypes.size());
    public List<Class<? extends Pet>> types(){
        return types;
    }
    public static void main(String[] args){
        System.out.println(types);
        System.out.println(allTypes.size());
    }
}
