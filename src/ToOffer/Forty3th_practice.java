package ToOffer;

public class Forty3th_practice {
    /**
     *根据规律来的
     */
    public int FindSum1(int n){
        int cnt = 0;
        for(int i=1;i<n;i*=10){
            int a = n/i, b = n%i;
            cnt+= (a+8)/10*i+(a%10==1?b+1:0);
        }
        return cnt;
    }
}
