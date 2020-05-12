package ToOffer;

public class Sixty5th {
    /**
     * 不用加减乘除做加法
     */
    public int Add(int a,int b){
        //a^b不会考虑进位，而a&b<<1每次都会把进位补上(自己的说法)
        return b==0?a:Add(a^b,a&b<<1);
    }
}
