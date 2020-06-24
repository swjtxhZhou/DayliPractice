package ToOffer.practice;

public class To63 {
    /**
     *给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     * 注意：你不能在买入股票前卖出股票。
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     * 考察点，贪心算法
     * 思路：
     * 1、两个指针，记录第一个数字为最小值，第二个数字为最大值
     * 2、记录一个动态的差值，将最大值与最小值的差与动态差值对比取大
     * 3、如果两者的差小于0，将最小值往后移动到最大值的位置,最大值往后走一位
     */
    public int maxProfit(int[] prices) {
        int low = 0;
        int high = 1;
        int ret = 0;
        while(high<=prices.length-1){
            int num=prices[high]-prices[low];
            if(num<=0) {
                low = high;
                high++;
            }else{
                ret = Math.max(ret,high-low);
            }
        }
        return ret;
    }
}