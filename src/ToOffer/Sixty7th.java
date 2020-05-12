package ToOffer;

public class Sixty7th {
    /**
     * 把字符串转换成整数
     * 将一个字符串转换成一个整数，字符串不是一个合法的数值则返回 0，要求不能使用字符串转换整数的库函数。
     */
    public int StrToInt(String str) {
        if (str == null)
            return 0;
        int result = 0;
        boolean negative = false;//是否负数
        int i = 0, len = str.length();
        /**
         * limit 默认初始化为*负的*最大正整数 ，假如字符串表示的是正数
         * 由于int的范围为-2147483648~2147483647
         * 那么result(在返回之前一直是负数形式)就必须和这个最大正数的负数来比较来判断是否溢出，
         */
        int limit = - Integer.MAX_VALUE;
        int multmin;//这个是拿来干嘛的
        int digit;

        if (len > 0) {
            char firstChar = str.charAt(0);//首先看第一位
            if (firstChar < '0') { // 有可能是 "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;//在负号的情况下，判断溢出的值就变成了 整数的 最小负数了
                } else if (firstChar != '+')//第一位不是数字和-只能是+
                    return 0;
                if (len == 1) // Cannot have lone "+" or "-"
                    return 0;
                i++;
            }
            //此时第一位已经判断完了
            multmin = limit / 10;//?为什么要除以10
            //继续判断接下来的位置,统一按照负数处理
            while (i < len) {
                digit = str.charAt(i++)-'0';
                if (digit < 0 || digit > 9)//不是数字字符
                    return 0;
                //判断溢出，这里是怎么判断溢出的喃？
                if (result < multmin) {//当前的result接下来会赋值为10*result，这里也是提前判断是否溢出
                    return 0;
                }
                result *= 10;//把当前位网上提
                //继续判断溢出，这里其实是提前判断 result-digit<limit
                if (result < limit + digit) {
                    return 0;
                }
                result -= digit;
            }
        } else {
            return 0;
        }
        //如果是正数就返回-result（result一直是负数）
        return negative ? result : -result;
    }
}
