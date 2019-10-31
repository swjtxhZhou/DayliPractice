package September6th;

import September5th.Rtti.toys.FancyToy;
import September5th.Rtti.toys.Toy;

public class GenericToyTest {
    public static void main(String[] args)throws Exception{
        Class<FancyToy> ftClass = FancyToy.class;
        /**
         * 将泛型语法用于Class对象：newInstance（）将返回该对象得确切类型
         */
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up = ftClass.getSuperclass();
//        Class<Toy> up2 = ftClass.getSuperclass();getSuperClass()返回的是基类（不是接口）
        Object object=up.newInstance();//返回值不是精确类型，而只是Object

    }
}
