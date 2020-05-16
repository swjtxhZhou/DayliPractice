package Algorithem.DynamicPlan.数组区间;

public class ArithmeticSlices {
    /**
     * 数组中等差递增子区间的个数
     */
    public int numberOfArithmeitcSlices(int[] A){
        //先判断参数
        if(A==null||A.length==0)return 0;
        //需要的参数
        int[] dp = new int[A.length-1];
        for(int i=2;i<A.length;i++){
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                dp[i]=dp[i-1]+1;
            }
        }
        //把所有的dp加在一起
        int total=0;
        for(int cnt:dp){
            total+=cnt;
        }
        return total;
    }
}
