package August29th.String.FormatterClass;

import java.util.Formatter;

public class Receipt {
    private double total = 0;
    private Formatter f = new Formatter(System.out);
    public void printTitle(){
        /**
         * 默认情况下数据是右对齐的，可以通过使用“-”标志来改变对齐方向
         */
        f.format("%-15s %5s %10s\n","Item","Qty","Price");
        f.format("%-15s %5s %10s\n","----","---","-----");
    }
    public void print(String name,int qty,double price){
        /**
         * precision应用于String时，表示打印String时输出字符的最大数量
         * 应用于浮点数时，表示小数部分要显示出来的位数（默认是六位数）
         */
        f.format("%-15.15s %5d %10.2f\n",name,qty,price);
        total+=price;
    }
    public void printTotal(){
        f.format("%-15s %5s %10.2f\n","Tax","",total*0.06);
        f.format("%-15s %5s %10s\n","","","-----");
        f.format("%-15s %5s %10.2f\n","Total","",total*1.06);
    }
    public static void main(String[] args){
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("jack`s magic beans",4,4.5);
        receipt.print("princess pears",3,5.1);
        receipt.print("three bears porriage",1,14.29);
        receipt.printTotal();
    }

}
