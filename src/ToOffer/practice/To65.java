package ToOffer.practice;

public class To65 {
    /**
     *写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     * 不允许使用四则运算符就要考虑位运算符
     * (^表示异或运算符，相同为0相异为1)0^0=0,0^1=1,1^0=1,1^1=0,那么a^b就是每一位都不考虑进位的和。
     * （&表示与运算符，同时为1才会是1，1&1=1，1&0=0，0&1=0，0&0=0）（a&b）<<1,就是表示进位信息
     */
    public int Add(int num1,int num2) {
        return num2==0?num1:Add(num1^num2,(num1&num2)<<1);
    }

}
