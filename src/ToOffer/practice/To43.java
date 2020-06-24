package ToOffer.practice;

public class To43 {
    /**
     * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
     *
     */

    //笨的办法
    public int NumberOf1Between1AndN_Solution_slow(int n) {
        int count = 0;
        for(int i=1;i<=n;i++){
            count+=count1(i);
        }
        return count;
    }
    public int count1(int n){
        String str = n+"";
        char[] chs = str.toCharArray();
        int cnt = 0;
        for(int ch:chs){
            if(ch=='1'){
                cnt++;
            }
        }
        return cnt;
    }
    //归纳的办法
    public int NumberOf1Between1AndN_Solution(int n) {
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m, b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }
}
