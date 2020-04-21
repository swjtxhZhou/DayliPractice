package thinkingInJava.part1;

/**
 * 创建enum的时候，编译器会为你生成一个相关的类，这个类继承自java.lang.Enum
 */
enum Shrubbery {GROUND, CRAWLING, HANING}

public class EnumClass {
    public static void main(String[] args){
        for(Shrubbery s : Shrubbery.values()){
            /**
             * ordinal()方法返回一个int值，这是每个enum实列在声明时的次序，从0开始
             * 可以使用==来比较enum实列，编译器会自动为你提供equals（）和hashCode（）方法。
             * enum实现了comparable，所以可以使用compareTo（）方法
             * 再enum实列上使用getDeclaringClass()方法，就能知道其所属的enum类
             * name（）返回enum实列声明时的名字，这与使用toString（）方法效果相同
             */
            System.out.println(s+" ordinal:"+s.ordinal());
            System.out.println(s.compareTo(Shrubbery.CRAWLING)+" ");
            System.out.println(s == Shrubbery.CRAWLING );
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("-------------");
        }
        for(String s:"HANING CRAWLING GROUND".split(" ")){
            /**
             * valueOf（）是在Enum中定义的static方法，他根据给定的名字返回相应的enum实列，如果不存在给定名字的实列，将会抛出异常
             */
            Shrubbery shru = Enum.valueOf(Shrubbery.class,s);
            System.out.println(shru);
        }
    }
}
