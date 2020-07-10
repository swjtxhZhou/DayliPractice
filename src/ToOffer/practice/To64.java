package ToOffer.practice;

public class To64 {
    /**
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * 前面的条件相当于是不允许使用迭代
     * 用背公式解决 （n+1）n/2=(n2+n)/2
     * 不能使用循环，不可能使用穷举，就只能使用递归来做
     * 又不能使用三目运算符，使用&&的性质，从左到右执行
     */
//    public int Sum_Solution(int n) {
//        return (int)(Math.pow(n,2)+n)>>1;
//    }
    public int Sum_Solution(int n) {
        int sum = n;
        boolean a = (n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }
}
