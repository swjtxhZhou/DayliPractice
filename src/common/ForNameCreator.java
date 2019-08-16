package common;

import common.pets.Pet;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetsCreator{
    private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
    private static String[] typeName = {
            "common.pets.Mutt",
            "common.pets.Pug",
            "common.pets.EgyptianMau",
            "common.pets.Manx",
            "common.pets.Cymric",
            "common.pets.Rat",
            "common.pets.Mouse",
            "common.pets.Hamster"
    };
    @SuppressWarnings("unchecked")
    private static void loader(){
        try{
            for(String name:typeName){
                /**
                 * 传递一个在编译期无法验证的String。由于Pet对象在common包中，需要使用包名来引用这些类
                 * Class.forName（）创建了Class对象的list
                 * 为了产生实际类型的Class对象的List，必须使用转型，这会产生编译期警告。
                 * loader()方法被单独定义，然后被置于一个静态初始化子句中，因为@SuppressWarning注解不能直接置于静态
                 * 初始化子句上
                 */
                types.add((Class<? extends Pet>)Class.forName(name));
            }
        }catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
    static {loader();}
    public List<Class<? extends Pet>> types(){return types;}
}
