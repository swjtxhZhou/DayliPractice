package ToOffer;

public class Sixty4th {
    /**
     * 求 1+2+3+...+n
     * 要求不能使用乘除法、for、while、if、else、switch、case 等关键字及条件判断语句 A ? B : C。
     */
    public int Sum_solution(int n){
        int sum = n;
        //第二个条件永远为真，由第一个条件判断是否继续向下执行，到达最底层Sum的值就从1开始返回并累加到sum
        boolean b = (n>0)&&((sum+=Sum_solution(n-1))>0);
        return sum;
    }
}
