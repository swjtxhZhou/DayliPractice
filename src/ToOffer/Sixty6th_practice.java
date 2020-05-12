package ToOffer;

public class Sixty6th_practice {
    public int[]  Mutiply(int[] A){
        int n = A.length;
        int[] B = new int[n];
        for(int i=0,product=1;i<n;product*=A[i],i++){//i++在后面，所以最后一个是A[i-1]
            //每次迭代，product也会增加，此时B[i]=A[0]*...*A[i-1]
            B[i] = product;
        }
        for(int i=n-1,product=1;i>0;product*=A[i],i--){
            //从右到左算B[i]*=A[i+1]*...*A[n-1]
            B[i] *= product;
        }
        return B;
    }
}
