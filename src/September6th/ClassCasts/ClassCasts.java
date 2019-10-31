package September6th.ClassCasts;

public class ClassCasts {
    public static void main(String[] args){
        Buliding b = new House();
        Class<House> houseType = House.class;
        /**
         * cast()方法接受参数对象，并将其转型为Class引用得类型。
         * 最后一行代码相比，这种转型好像做了很多额外的工作。
         * 在编写泛型代码时，如果存储了Class引用，并希望以后通过这个引用来执行转型，这种情况就会发生。
         */
        House h = houseType.cast(b);
        h = (House)b;
    }
}
