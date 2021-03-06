package thinkingInJava.October10th;

import thinkingInJava.October9th.Generator.Generator;

public class BasicGenerator<T> implements Generator {
    private Class<T> type;
    public BasicGenerator(Class<T> type){this.type = type;}
    public T next(){
        try{
            return type.newInstance();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    public static <T> Generator<T> create(Class<T> type){
        return new BasicGenerator<T>(type);
    }
}
