package August8th.part2_nested;

import August7th.part1.part5_innerClasses.Contents;
import August7th.part1.part5_innerClasses.Destination;

public class Parcel11 {
    private static class ParcelContents implements Contents{
        private int i = 11;
        public int value(){
            return 1;
        }
    }
    protected static class ParcelDestination implements Destination{
        private String label;
        private ParcelDestination(String whereTo){
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }
        /**
         * 嵌套类能包含其他的静态元素
         */
        public static void f(){}
        static int x=10;
        static class AnotherLevel{
            public static void f(){}
            static int x=10;
        }
    }
    public static Destination destination(String s){
        return new ParcelDestination(s);
    }
    public static Contents contents(){
        return new ParcelContents();
    }
    public static void main(String[] args){
        /**
         * 在普通的内部类中，通过一个特殊的this引用可以链接到其外围类对象。嵌套类没有这个特殊的this引用，
         */
        Contents c = contents();
        Destination d = destination("self");
    }

}
