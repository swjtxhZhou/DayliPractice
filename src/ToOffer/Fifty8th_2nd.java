package ToOffer;

public class Fifty8th_2nd {
    /**
     * 左旋转字符串
     * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出
     * Input:
     * S="abcXYZdef"
     * K=3
     *
     * Output:
     * "XYZdefabc"
     * 先将 "abc" 和 "XYZdef" 分别翻转，得到 "cbafedZYX"，然后再把整个字符串翻转得到 "XYZdefabc"。
     * 思路还是翻转两次
     */
    public String LeftRotateString(String str, int n) {
        //必须要判断这个，不然通过不了
        if (n >= str.length())
            return str;
        char[] arr = str.toCharArray();
        reverse(arr,0,n-1);
        reverse(arr,n,arr.length-1);
        reverse(arr,0,arr.length-1);
        return new String(arr);
    }
    //翻转方法
    private void reverse(char[] arr,int i,int j){
        while(i<j){
            sweap(arr,i++,j--);
        }
    }
    private void sweap(char[] arr,int i,int j){
        char temp =arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
