package ToOffer;

public class Fifteen {
    /**
     * 输入一个整数，输出该数二进制表示中 1 的个数。
     * 该位运算去除 n 的位级表示中最低的那一位
     * n       : 10110100
     * n-1     : 10110011
     * n&(n-1) : 10110000
     * 这个过程将去除最低一位的1，当所有的1去除完，整个的值就变成了0
     */
    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }
    public int NumberOf1_bitCount(int n) {
        return Integer.bitCount(n);
    }
}
