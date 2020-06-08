package ToOffer.practice;

public class To15 {
    /**
     * 输入一个整数，输出该数二进制表示中1的个数。
     *判断是正数还是负数
     * 考察的是把一个整数考虑成二进制形式，只要与本身减一相与就会抹去最低位的1.当所有位的1都被抹去整个数字就是0
     */
    public int NumberOf1(int n) {
        int cnt =0;
        while(n!=0){
            cnt++;
            n&=(n-1);
        }
        return cnt;
    }
}
