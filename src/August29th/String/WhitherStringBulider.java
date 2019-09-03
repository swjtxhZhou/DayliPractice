package August29th.String;

/**
 * 编译器自动地优化
 */
public class WhitherStringBulider {
    public String implicit(String[] fileds){
        String result = "";
        /**
         * 每一次循环就会创建一个新的StringBulider对象
         */
        for(int i=0;i<fileds.length;i++){
            result+=fileds[i];
        }
        return result;
    }
    public String explicit(String[] fields){
        StringBuilder result = new StringBuilder();
        /**
         * 只生成了一个StringBuilder对象
         */
        for(int i=0; i<fields.length;i++){
            result.append(fields[i]);
        }
        return result.toString();
    }
}
