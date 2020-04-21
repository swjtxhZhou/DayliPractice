package thinkingInJava.October10th.InstantiateType;

public class ClassAsFactory<T> {
    T x;
    public ClassAsFactory(Class<T> kind){
        try{
            x=kind.newInstance();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
