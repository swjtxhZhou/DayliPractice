package ToOffer;

public class Fifteen_practice {
    public int Numberof1(int n){
        int cnt=0;
        while(n!=0){
            cnt++;
            n&=(n-1);
        }
        return cnt;
    }
}
