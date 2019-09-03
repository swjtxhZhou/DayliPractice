package August30th.Pattern;

public class IntegerMatch {
    public static void main(String[] args){
        /**
         * 可能有一个负号，后面跟着一位或多位数字
         */
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        /**
         * 这个正则表达式表示字符的起始字符可能是一个-或+，或二者都没有（因为后面跟着？修饰符）。
         * 字符+在正则表达式中有特殊的意义，所以必须使用\\将其转义，使之成为表达式中的一个字符。
         */
        System.out.println("+911".matches("(-|\\+)?\\d+"));
    }
}
