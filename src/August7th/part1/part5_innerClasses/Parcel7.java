package August7th.part1.part5_innerClasses;

/**
 * 匿名内部类
 */
public class Parcel7 {
    public Contents contents(){
        /**
         * 返回的类是匿名的
         */
        return new Contents() {
            private int i = 11;
            @Override
            public int value() {
                return i;
            }
        };
    }
    public static void main(String[] args){
        Parcel7 p = new Parcel7();
        Contents c= p.contents();
    }
}
