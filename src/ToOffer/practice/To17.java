package ToOffer.practice;

public class To17 {
    /**
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
     * 这里有个限制条件，n可能非常的大，不能直接用int表示数字，用char数组进行存储
     *使用回溯法得到所有的数
     */
    public void print1ToMaxOfNDigits(int n){
        if(n<=0)return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number,0);
    }
    private void print1ToMaxOfNDigits(char[] number,int digit){
        //一开始是回溯返回条件
        if(digit==number.length){
            printNumber(number);
            return;
        }
        //递归
        for(int i=0;i<10;i++){
            number[digit] = (char) ('0'+i);
            print1ToMaxOfNDigits(number,digit);
        }
    }
    //将一个char数组打印出来
    private void printNumber(char[] number){
        int index =0;//这个判断前面有多少个零，前面是零的不用打印
        while(index<number.length&&number[index]=='0'){//这里先判断number是否越界，再判断是否是零，如果先判断是否是零的话，后面可能抛出数组越界异常
            index++;
        }
        while(index<number.length){
            System.out.print(number[index++]);
        }
        System.out.println();//打完一个数字空一行
    }
}
