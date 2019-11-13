package Chapter17th.part2.part9th;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class SpringDetector {
    /**
     * deterSpring使用了反射机制来实列化及使用GroundDog或任何继承了它的类
     * @param type
     * @param <T>
     * @throws Exception
     */
    public static <T extends GroundDog> void detectSpring(Class<T> type) throws Exception{
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<GroundDog,Prediction> map = new HashMap<>();
        for(int i = 0;i<10;i++){
             map.put(ghog.newInstance(i),new Prediction());
        }
        System.out.println("map="+map);
        GroundDog gh = ghog.newInstance(3);
        System.out.println("looking up prediction for "+gh);
        /**
         * 无法找到GroundDog（3），两者的散列码是不同的
         * GroundDog自动地继承自基类Object，所以这里使用了Object的hashCode（）方法生成散列码，这个方法是默认使用地址计算散列码。
         */
        if(map.containsKey(gh)){
            System.out.println(map.get(gh));
        }else{
            System.out.println("key not found "+ gh);
        }
    }
    public static void main(String[] args) throws Exception{
        detectSpring(GroundDog.class);
    }
}
