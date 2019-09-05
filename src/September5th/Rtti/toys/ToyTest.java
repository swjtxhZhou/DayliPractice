package September5th.Rtti.toys;

import static java.lang.System.out;
public class ToyTest {
    static void printInfo(Class cc){
        out.println("Class name :"+cc.getName()+" is interface["+cc.isInterface()+"]");
        out.println("Simple name :"+cc.getSimpleName());//产生不含包名的类名
        out.println("Canonical name :"+cc.getCanonicalName());
    }
    public static void main(String[] args){
        Class cc = null;
        try{
            /**
             * 传递给forName（）的字符串中，必须使用全限定名（包含包名）
             */
            cc = Class.forName("September5th.Rtti.toys.FancyToy");
        }catch(ClassNotFoundException e){
            out.println("Couldn`t find FancyToy");
            System.exit(1);
        }
        printInfo(cc);
        /**
         * getInterfaces()返回的是Class对象，返回Class对象所包含的接口
         */
        for(Class face:cc.getInterfaces()){
            printInfo(face);
        }
        Class up = cc.getSuperclass();//查询其直接基类，这将返回你可以用来进一步查询的Class对象，这样你能发现一个对象完整的继承结构
        Object obj= null;
        try{
            /**
             * newInstance()方法是实现“虚拟构造器”的一种途径，虚拟构造器允许你声明“我不知道你的确切类型，但是无论如何要正确的床建自己”
             * 创建新实列时，会得到Object引用，但是这个引用指向的是Toy对象，
             * 使用newInstance（）创建的类，必须带有默认的构造器
             */
            obj=up.newInstance();
        }catch (InstantiationException e){
            out.println("cannot instantiate");
            System.exit(1);
        }catch(IllegalAccessException e){
            out.println("cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
