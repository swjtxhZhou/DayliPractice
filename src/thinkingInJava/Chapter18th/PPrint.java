package thinkingInJava.Chapter18th;

import java.util.Arrays;
import java.util.Collection;

public class PPrint {
    /**
     * 容器默认的toString（）方法会在单个行中打印容器中的所有元素。对于大型集合来说，这会变的很难阅读，
     * 因此你可能希望使用可替换的格式化机制。下面便是一个可以添加新行并缩排所有元素的工具
     * @param c
     * @return
     */
    public static String pformat(Collection<?> c){
        if(c.size() == 0) return "[]";//没有任何元素
        StringBuffer result = new StringBuffer("[");
        for(Object elem:c){
            if(c.size() !=1){
                result.append("\n ");
            }
            result.append(elem);
        }
        if(c.size() != 1){
            result.append("\n ");
        }
        result.append("]");
        return result.toString();
    }
    public static void pprint(Collection<?> c){
        System.out.println(pformat(c));
    }

    public static void pprint(Object[] c){
        System.out.println(Arrays.asList(c));
    }
}
