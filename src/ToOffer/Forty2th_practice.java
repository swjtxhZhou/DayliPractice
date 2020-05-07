package ToOffer;

public class Forty2th_practice {
    /**
     * 动态规划
     * @param array
     * @return
     */
    public int findMaxSum(int[] array){
        if(array.length == 0|| array == null ){
            return 0;
        }
        int sum = 0;
        int greatSum = Integer.MIN_VALUE;
        for(int val:array){
            sum = sum<=0?val:val+sum;
            greatSum = Math.max(greatSum,sum);
        }
        return greatSum;
    }
}
