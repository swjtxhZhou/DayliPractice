package Chapter17th.part2.part9th;

import Chapter17th.part2.Countries;

import java.util.*;

public class SimpleHashMap<K,V> extends AbstractMap<K,V> {
    static final int SIZE = 997;
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];//创建一个链表数组
    public V put(K key,V value){
        V oldValue = null;
        int index = Math.abs(key.hashCode())%SIZE;//找到适当位置的桶
        if(buckets[index]==null){//若当前这个桶为空，则创建一个链表
            buckets[index] = new LinkedList<MapEntry<K,V>>();
        }
        LinkedList<MapEntry<K,V>> bucket = buckets[index];//用bucket表示当前这条链表（桶）
        MapEntry<K,V> pair = new MapEntry<>(key, value);//把键值对包装起来
        boolean found = false;
        ListIterator<MapEntry<K,V>> it = bucket.listIterator();
        while(it.hasNext()){//遍历该条链表
            MapEntry<K,V> ipair = it.next();
            if(ipair.getKey().equals(key)){//如果已经存在这个key值，则把当前值取出来，把新的值放进去
                oldValue = ipair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        if(!found){
            buckets[index].add(pair);
        }
        return oldValue;
    }
    public V get(Object key){//泛型后引进的原因，该处只能使用Object
        int index = Math.abs(key.hashCode())%SIZE;
        if(buckets[index]==null)return null;
        for(MapEntry<K,V> ipair:buckets[index]){
            if(ipair.getKey().equals(key)){//通过key发现目标元素
                return ipair.getValue();
            }
        }
        return null;//遍历该条链表没有发现元素
    }
    public Set<Map.Entry<K,V>> entrySet(){
        Set<Map.Entry<K,V>> set = new HashSet<>();
        for(LinkedList<MapEntry<K,V>> bucket:buckets){
            if(bucket == null) continue;
            for(MapEntry<K,V> mpair:bucket){
                set.add(mpair);
            }
        }
        return set;
    }
    public static void main(String[] args){
        SimpleHashMap<String,String> m = new SimpleHashMap<>();
        m.putAll(Countries.caplists(3));
        System.out.println(m);
        System.out.println(m.entrySet());

        String[] hellos = "hello hello".split(" ");
        /**
         * String有个特点，如果String对象都包含相同的字符串序列，那么这些String对象都映射到同一块内存区域。
         * 虽然生成两个实例，并且相互独立，但是对它们使用hashCode（）方法会生成同一结果。
         */
        System.out.println(hellos[0].hashCode()+" ,"+hellos[1].hashCode());
    }
}
