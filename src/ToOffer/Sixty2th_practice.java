package ToOffer;

public class Sixty2th_practice {
    public int lastRemaining_solution(int n,int m){
        if(n==0)return -1;
        if(n==1)return 0;
        return (lastRemaining_solution(n-1,m)+m)%n;
    }
}
