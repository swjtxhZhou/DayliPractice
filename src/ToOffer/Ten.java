package ToOffer;

public class Ten {
    /**
     * 求斐波那契数列的第 n 项，n <= 39。
     * 如果使用递归求解，会重复计算一些子问题。例如，计算 f(4) 需要计算 f(3) 和 f(2)，计算 f(3) 需要计算 f(2) 和 f(1)，可以看到 f(2) 被重复计算了。
     * 递归是将一个问题划分成多个子问题求解，动态规划也是如此，但是动态规划会把子问题的解缓存起来，从而避免重复求解子问题。
     */
    public int Fibonacci(int n){
        /**
         * 时间复杂度：O(n)
         * 空间复杂度：O(n)
         */
        if(n<=1){return n;}
        int[] fib = new int[n+1];//用来存储斐波那契序列
        fib[1] = 1;
        for(int i =2;i<n+1;i++){
            fib[i] = fib[i-1]+fib[i-2]; //没有使用到递归，这样把之前的结果都缓存起来了，减少了时间复杂度
        }
        return fib[n];
    }
    /**
     * 这个问题并没有要求出整个序列，而且只需要前两项就能求出第n项的值
     */
    public int Fibonacci2(int n){
        /**
         * 时间复杂度：O(n)
         * 空间复杂度：O(1)
         */
        if(n<=1){return n;}
        int pre1= 0,pre2=1;
        int fib = 0;
        for(int i =2; i<n;i++){
            fib = pre1+pre2;
            pre1 = pre2;
            pre2 = fib;
        }
        return fib;
    }
}
