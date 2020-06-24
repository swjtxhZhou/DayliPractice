package ToOffer.practice;

public class To58_2 {
    /**
     * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
     * 考察点：字符串
     * 想法：
     * 1、不要对字符串对象本身进行操作，而是用字符数组或者StringBuffer
     * 题解参考：
     * 分别旋转将要移动到末尾的子字符串和剩余部分的子字符串部分，然后整体旋转字符串，就能将目标子字符串左移到了原来的末尾
     * 左移其实和逆序输出字符串是一样的，只不过没有了空格隔开
     *
     */
    public String LeftRotateString(String str,int n) {
        if(str==null||str.length()==0){
            return new String();
        }
        char[] chars = str.toCharArray();
        int low=0,high=0;
        while(high<=str.length()){
            if(high==str.length()||high==n){
                Reverse(chars,low,high-1);
                low = high;
            }
            high++;
        }
        Reverse(chars,0,str.length()-1);
        return new String(chars);

    }
    private void Reverse(char[] array,int low,int high){
        while(low<high){
            Swap(array,low,high);
            low++;
            high--;
        }
    }
    private void Swap(char[] array,int low,int high){
        char temp = array[low];
        array[low] = array[high];
        array[high] = temp;
    }
}
