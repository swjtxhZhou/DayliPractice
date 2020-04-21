package thinkingInJava.part1.part7;

import thinkingInJava.part1.part6.Enums;

public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;

    /**
     * 每一个Courese的实例都将其对应的Class对象作为构造器的参数，通过getEnumConstants（）中被用到
     * @param kind
     */
    private Course(Class<? extends Food> kind){
        values = kind.getEnumConstants();
    }
    public Food randomSelection(){
        return Enums.random(values);
    }
}
