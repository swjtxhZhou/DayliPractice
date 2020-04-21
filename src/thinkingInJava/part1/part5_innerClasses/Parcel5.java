package thinkingInJava.part1.part5_innerClasses;

/**
 * 局部内部类，一个定义在方法的类
 */
public class Parcel5 {
    public Destination destination(String s){
        class PDestination implements Destination{
            private String label;
            private PDestination(String whereTo){
                label = whereTo;
            }
            public String readLabel(){
                return label;
            }
        }
        return new PDestination(s);
    }
    public static void main(String[] args){
        Parcel5 p = new Parcel5();
        Destination d = p.destination("hell");
        System.out.println(d.readLabel());
    }
}
