package September6th;

import java.util.List;
import java.util.*;

/**
 * 使用了一个泛型类语法，它存储了一个类引用
 * 这个类必须假设与它一起工作的任何类型都具有一个默认的构造器（无参构造器），并且如果不符合条件，你将得到一个异常。编译器对该程序不会产生任何警告信息。
 * @param <T>
 */
public class FilledList<T> {
    private Class<T> type;
    public FilledList(Class<T> type){
        this.type = type;
    }
    public List create(int nElements){
        List<T> result = new ArrayList<T>();
        try{
            for(int i= 0; i<nElements;i++){
                result.add(type.newInstance());
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return result;
    }
    public static void main(String[] args){
        FilledList<CountedInteger> f1 = new FilledList<CountedInteger>(CountedInteger.class);
        System.out.println(f1.create(15));
    }
}
