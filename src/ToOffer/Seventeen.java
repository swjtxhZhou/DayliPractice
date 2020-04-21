package ToOffer;

//有点没搞懂
public class Seventeen {
    /**
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
     * 由于 n 可能会非常大，因此不能直接用 int 表示数字，而是用 char 数组进行存储。
     *
     * 使用回溯法得到所有的数。
     */
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number) {//把char数组打印成数字
        int index = 0;
        while (index < number.length && number[index] == '0')//判断最前面的数字是否为0，index的作用就是不去打印多余的0
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }
    public static void main(String[] args){
        Seventeen seventeen= new Seventeen();
//        seventeen.print1ToMaxOfNDigits(3);
        char[] number = {'0','1','2'};
        seventeen.printNumber(number);
        Seventeen_practice seventeen_practice = new Seventeen_practice();
        seventeen_practice.printNumber(number);
    }

}
