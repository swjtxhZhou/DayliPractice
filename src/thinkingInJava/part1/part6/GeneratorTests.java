package thinkingInJava.part1.part6;

import thinkingInJava.October9th.Generator.Generator;

public class GeneratorTests {
    public static int size = 10;
    public static void test(Class<?> surroundingClass){
        for(Class<?> type : surroundingClass.getClasses()){
            System.out.println(type.getSimpleName()+": ");
            try{
                Generator<?> g = (Generator<?>)type.newInstance();
                for(int i =0;i<size;i++){
                    System.out.print(g.next()+" ");
                }
                System.out.println();
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args){
        test(CountingGenerator.class);
    }
}
