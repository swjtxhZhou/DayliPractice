package thinkingInJava.August23th.part2;

/**
 * 加入额外的构造器和成员
 */

public class MyException2 extends Exception{
    private int x;
    public MyException2(){}
    public MyException2(String msg){
        super(msg);
    }
    public MyException2(String msg,int x){
        super(msg);
        this.x = x;
    }
    public int val(){
        return x;
    }
    public String getMseesge(){
        return "Detail Message:"+x+" "+super.getMessage();
    }
}
