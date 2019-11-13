package Chapter17th.part2;

import java.util.*;

public class Countries {
    public static final String[][] DATA={
            {"1afewafj","1jfaoiwejfow"},{"2jawefowi","2hefoiawhef"},{"3afijoij","3infhawfe"}
    };

    /**
     * FlyWeightMap必须实现entrySet（）方法，他需要定制的Set实现和定制的Map。Entry类。
     *
     */
    private static class FlyweightMap extends AbstractMap<String,String>{
        /**
         * 每个Map.Entry对象都只存储了它的索引，而不是实际的键和值。
         */
        private static class Entry implements Map.Entry<String,String>{
            int index;
            Entry(int index){this.index = index;}
            public boolean equals(Object o){
                return DATA[index][0].equals(o);
            }
            public String getKey(){return DATA[index][0];}
            public String getValue(){return DATA[index][1];}
            public String setValue(String value){
                throw new UnsupportedOperationException();
            }
            public int hashCode(){
                return DATA[index][0].hashCode();
            }
        }
        static class EntrySet extends AbstractSet<Map.Entry<String,String>>{
            private int size;
            EntrySet(int size){
                if(size<0){
                    this.size=0;
                }else if(size>DATA.length){
                    this.size = DATA.length;
                }else{
                    this.size = size;
                }
            }
            public int size(){
                return size;
            }
            private class Iter implements Iterator<Map.Entry<String,String>>{
                private Entry entry = new Entry(-1);
                public boolean hasNext(){
                    return entry.index<size-1;
                }
                public Map.Entry<String,String> next(){
                    entry.index++;
                    return entry;
                }
                public void remove(){
                    throw new UnsupportedOperationException();
                }
            }
            public Iterator<Map.Entry<String,String>> iterator(){
                return new Iter();
            }
        }
        private static Set<Map.Entry<String,String>> entries = new EntrySet(DATA.length);
        public Set<Map.Entry<String,String>> entrySet(){
            return entries;
        }
    }

    /**
     * select方法（）将产生一个包含指定尺寸的EntrySet的FlyWeightMap，它会被用于重载过的capitals（）和names（）
     * @param size
     * @return
     */
    static Map<String,String> select (final int size){
        return new FlyweightMap(){
            public Set<Map.Entry<String,String>> entrySet(){
                return new EntrySet(size);
            }
        };
    }
    static Map<String,String> map = new FlyweightMap();
    public static Map<String,String> caplists(int size){
        return select(size);
    }
    static List<String> names = new ArrayList<>(map.keySet());
    public static List<String> names(){
        return names;
    }
    public static List<String> names(int size){
        return new ArrayList<>(select(size).keySet());
    }

    public static void main(String[] args){
        System.out.println(caplists(2));
        System.out.println(names(2));
        System.out.println(new HashMap<String,String>(caplists(2)));
        System.out.println(new HashSet<String>(names(2)));
    }
}
