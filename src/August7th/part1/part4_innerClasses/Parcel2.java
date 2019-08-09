package August7th.part1.part4_innerClasses;

public class Parcel2 {
    class Contents{
        private int i=11;
        public int value(){
            return i;
        }
    }
    class Destination{
        private String label;
        Destination(String whereTo){
            label = whereTo;
        }
        String readLabel(){
            return label;
        }
    }
    public Contents contents(){
        return new Contents();
    }
    public Destination destination(String s){
        return new Destination(s);
    }
    public void ship(String dest){
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel()+" "+c.value());
    }
    public static void main(String[] args){
        Parcel2 p= new Parcel2();
        p.ship("hell");
        /**
         * 从外部类的非静态方法之外的任意位置创建某个内部类的对象
         */
        Parcel2.Destination d = p.destination("get down");
        Parcel2.Contents c = p.contents();

    }
}
