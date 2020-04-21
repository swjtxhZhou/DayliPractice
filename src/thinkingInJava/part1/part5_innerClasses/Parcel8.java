package thinkingInJava.part1.part5_innerClasses;

/**
 * 基类需要一个有参数的构造器，只需要简单地传递合适的参数给基类的构造器即可
 */

public class Parcel8 {
    public Wrapping wrapping(int x){
        return new Wrapping(x){
            public int value(){
                return super.value()*47;
            }
        };
    }
    public static void main(String[] args){
        Parcel8 p = new Parcel8();
        Wrapping w= p.wrapping(10);
    }
}
