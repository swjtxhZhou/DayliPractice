package ToOffer.practice;

public class To10_2 {
    /**
     * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
     * 主要能把动态变化的公式找出来
     *分析当n=1时只有一种方法，当n=2时有两种方式，当n=3时，可以先横着放一个，接下来的体积和n=2时的情况一样，所以f[n]=f[n-1]+f[n-2](n>3)
     */
    public int RectCover(int target) {
        if(target<=2)return target;
        //初始基
        int pre1=2,pre2=1;
        int result=0;
        for(int i=3;i<=target;i++){
            result = pre1+pre2;
            pre2 =pre1;
            pre1 = result;
        }
        return result;
    }
}
