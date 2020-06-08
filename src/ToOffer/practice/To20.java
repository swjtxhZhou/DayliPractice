package ToOffer.practice;

public class To20 {
    /**
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     * []  ： 字符集合
     * ()  ： 分组
     * ?   ： 重复 0 ~ 1 次
     * +   ： 重复 1 ~ n 次
     * *   ： 重复 0 ~ n 次
     * .   ： 任意字符
     * \\. ： 转义后的 .
     * \\d ： 数字
     */
    public boolean isNumeric(char[] str) {
        if(str==null||str.length==0)return false;
        //matcher(regex);是封装了Pattern.matches(regex,this);这里的this就是传入String构造器的String字符串。
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([Ee][+-]?\\d+)?");
    }
}
