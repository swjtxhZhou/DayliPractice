package thinkingInJava.October10th;

import java.util.HashSet;
import java.util.Set;

public class Sets {
    public static <T> Set<T> union(Set<T> a,Set<T> b){
        Set<T> result = new HashSet<T>(a);
        result.addAll(b);
        return result;
    }
    public static <T> Set<T> intersection(Set<T> a,Set<T> b){
        Set<T> result = new HashSet<T>(a);
        result.retainAll(b);//result中保留a和b的交集
        return result;
    }
    public static <T> Set<T> difference(Set<T> superSet,Set<T> subSet){
        Set<T> result = new HashSet<>(superSet);
        result.removeAll(subSet);//result中保留了除去superSet中与subSet中相同的部分。
        return result;
    }
    public static <T> Set<T> complement(Set<T> a,Set<T> b){
        return difference(union(a,b),intersection(a,b));//返回了a，b中的所有元素，去除了重复的元素
    }
}
