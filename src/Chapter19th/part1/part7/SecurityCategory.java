package Chapter19th.part1.part7;


import Chapter19th.part1.part6.Enums;

/**
 * 将enum嵌套进一个enum里面
 * Security接口的作用时将其所包含的enum组合成一个公共类型，然后SecurityCategory才能将Security中的enum作为其构造器的参数使用，以达到组织的使用
 */
enum SecurityCategory {
    STOCK(Security.Stock.class),
    BOND(Security.Bond.class);
    Security[] values;
    SecurityCategory(Class<? extends Security> kind){
        values = kind.getEnumConstants();
    }
    interface Security{
        enum Stock implements Security{SHORT,LONG,MARGIN}
        enum Bond implements Security{MUNICIPAL,JUNK}
    }
    public Security randomSelection(){
        return Enums.random(values);
    }
    public static void main(String[] args){
        for(int i=0;i<10;i++){
            SecurityCategory category = Enums.random(SecurityCategory.class);
            System.out.println(category+": "+category.randomSelection());
        }
    }
}
