package ToOffer.practice;

public class To14 {
    /**
     * 把一根绳子剪成多段，并且使得每段的长度乘积最大。
     * 尽可能多剪长度为 3 的绳子，并且不允许有长度为 1 的绳子出现。如果出现了，就从已经切好长度为 3 的绳子中拿出一段与长度为 1 的绳子重新组合，把它们切成两段长度为 2 的绳子。
     * 说明: 你可以假设 n 不小于 2 且不大于 58。
     */
    public int integerBreak(int n) {
        if(n==2)return 1;
        if(n==3)return 2;
        if(n==4)return 4;
        //n>=5以后需要进行判断
        int threeNum = n/3;
        if(n%3==1){
            //余数是1，需要拿一个3出来 凑成两个2
            return (int)Math.pow(3,threeNum-1)*4;
        }else if(n%3==2){
            return (int)Math.pow(3,threeNum)*2;
        }else{
            return (int)Math.pow(3,threeNum);
        }
    }

    //动态规划的求解方式
}
