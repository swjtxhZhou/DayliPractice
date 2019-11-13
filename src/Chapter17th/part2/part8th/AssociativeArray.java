package Chapter17th.part2.part8th;

public class AssociativeArray<K,V> {
    private Object[][] pairs;
    private int index;
    public AssociativeArray(int length){
        pairs = new Object[length][2];//第一位是键第二位是值，length表示能存放的长度
    }
    public void put(K key,V value){
        if(index >= pairs.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        pairs[index++] = new Object[]{key,value};
    }
    @SuppressWarnings("unchecked")
    public V get(K key){
        for(int i= 0; i<index;i++){
            if(key.equals(pairs[i][0])){//和每一个的键对比是否相同
                return (V)pairs[i][1];//打印该键对应的值
            }
        }
        return null;
    }
    public String toString(){
        StringBuffer result = new StringBuffer();
        for(int i =0; i<index;i++){
            result.append(pairs[i][0].toString());
            result.append(" : ");
            result.append(pairs[i][1].toString());
            if(i<index-1){
                result.append("\n");
            }
        }
        return result.toString();
    }
    public static void main(String[] args){
        AssociativeArray<String,String> map = new AssociativeArray<>(6);
        map.put("sky","blue");
        map.put("grass","green");
        map.put("ocean","dancing");
        map.put("tree","tall");
        map.put("earth","brown");
        map.put("sun","warm");
        try{
            map.put("extra","other");
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println(map);
        System.out.println(map.get("ocean"));
    }
}