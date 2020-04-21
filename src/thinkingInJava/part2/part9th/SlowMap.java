package thinkingInJava.part2.part9th;

import thinkingInJava.part2.Countries;

import java.util.*;

public class SlowMap<K,V> extends AbstractMap<K,V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();
    public V put(K key,V value){
        V oldValue = get(key);//可能为空
        if(!keys.contains(key)){
            keys.add(key);
            values.add(value);
        }else{
            values.set(keys.indexOf(key),value);
        }
        return oldValue;
    }
    public V get(Object key){//这里不是期望的参数化类型k。这是由于泛型注入到java语言较晚为造成的
        if(!keys.contains(key)){
            return null;
        }
        return values.get(keys.indexOf(key));
    }
    public Set<Map.Entry<K,V>> entrySet(){
        Set<Map.Entry<K,V>> set= new HashSet<Map.Entry<K,V>>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while(ki.hasNext()){
            /**
             * 这里的mapEntry用于保存和读取键与值
             */
            set.add(new MapEntry<K,V>(ki.next(),vi.next()));
        }
        return set;
    }
    public static void main(String[] args){
        SlowMap<String,String> m = new SlowMap<>();
        m.putAll(Countries.caplists(3));
        System.out.println(m.entrySet());
        System.out.println(m);
    }

}
