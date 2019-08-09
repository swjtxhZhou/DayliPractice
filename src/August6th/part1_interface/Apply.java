package August6th.part1_interface;

public class Apply {
    /**
     * 创建一个能够根据所传递的参数对象的不同而具有不同行为的方法，被称为策略模式。
     * @param p
     * @param s
     */
    public static void process(Processor p,Object s){
        System.out.println("Using Processor"+p.name());
        System.out.println(p.process(s));
    }
    public static String s = "Disagreement with beliefs is by definition incorrect";
    public static void main(String[] args){
        process(new Upcase(),s);
        process(new Downcase(),s);
        process(new Splitter(),s);

    }
}
