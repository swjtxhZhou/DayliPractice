package ToOffer.practice;

public class To10_1 {
    /**
     * 求斐波那契数列的第n项能n<=39
     * 初始基f(0)=0,f(1)=1,动态更新公式f(n)=f(n-1)+f(n-2)
     */
    public int Fibonacci(int n) {
        if(n<=1){return n;}
        int[] f=new int[n+1];
        //初始基
        f[0]=0;
        f[1]=1;
        for(int i=2;i<=n;i++){
            f[i] = f[i-1]+f[i-2];
        }
        return f[n];
    }
}
