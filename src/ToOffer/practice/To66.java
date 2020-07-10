package ToOffer.practice;

import java.util.Arrays;

public class To66 {
    /**
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
     * 上面描述的构建B数组的过程相当于把当前第i个A的元素剔除，再求A的数组的所有元素的乘积，而且不能用除法，意味着不能一次性求出所有A元素的乘积然后在对应除以其中一个元素。
     * 如果每次求一个B数组的元素就会需要乘以很多重复的A元素
     * 一开始想用递归+全局变量来做
     * 答案解析是使用两个循环,第一个循环从左向右乘到去掉的元素之前，第二个循环乘到从右向左去掉的元素之后，要注意product的初始取值很关键，取1就就能达到以上的目的
     */
    public int[] multiply(int[] A) {
        if(A.length==0)return new int[0];
        int n = A.length;
        int[] B = new int[n];
        Arrays.fill(B,1);
        for(int i=0,product=1;i<=n-1;product*=A[i],i++){
            B[i] = product;
        }
        for(int i=n-1,product=1;i>=0;product*=A[i],i--){
            B[i]*=product;
        }
        return B;
    }
}
