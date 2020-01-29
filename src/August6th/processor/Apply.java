package August6th.processor;

public class Apply {
    /**
     * 创建一个能够根据所传递的参数对象的不同而具有不同行为的方法，被称为策略模式。
     * @param p
     * @param s
     */
    public static void process(Processor p,Object s){
        System.out.println("Using Processor"+p.name());//打印对应类的名称
        System.out.println(p.process(s));//把Object的内容打印出来，s实际是一串字符串
    }
    public static String s = "Disagreement with beliefs is by definition incorrect";
    public static void main(String[] args){
        /**
         *分别传入一个Processor或者其子类
         * 子类的Processor中的process方法已经被覆盖了
         */
        process(new Upcase(),s);
        process(new Downcase(),s);
        process(new Splitter(),s);

    }
}
