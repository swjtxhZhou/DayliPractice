package ToOffer.practice;

public class To67 {
    /**
     * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
     * 输入一个字符串,包括数字字母符号,可以为空
     * 如果是合法的数值表达则返回该数字，否则返回0
     * 输入：
     * +2147483647
     * 1a33
     * 输出：
     * 2147483647
     * 0
     *
     * 这里的正常字符串应该指的的是“+/—”+“数字”的组合，只要不是这种组合就返回0
     * 需要用一个额外的内存来拼装最后返回的数字
     * 1、第一个字符可以是+或者-，或者直接是数字
     * 2、如果非首字符不是数字直接返回0.
     * 3、提前保存正负状态
     * 考察点：
     * 字符串和数字的相互转换。
     */
    public int StrToInt(String str) {
        if(str==null||str.length()==0)return 0;
        int length = str.length();
//        StringBuilder stringBuilder = new StringBuilder();
        boolean isNegative = str.charAt(0)=='-';
        int ret = 0;
//        if(isNegative){
//            stringBuilder.append('-');
//        }
        for(int i=0;i<length;i++){
            char c = str.charAt(i);
            if(i==0&&(c=='+'||c=='-')){
                //这里只会判断一次，就是第一个字符如果有符号就会跳过
                continue;
            }
            if(c<'0'||c>'9'){
                return 0;
            }
            ret=ret*10+c-'0';
        }
        return isNegative?-ret:ret;
    }
    public static void main(String[] args){
        To67 to67 = new To67();
        to67.StrToInt("1a33");
    }
}
