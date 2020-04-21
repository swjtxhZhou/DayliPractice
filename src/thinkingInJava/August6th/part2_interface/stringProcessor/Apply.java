package thinkingInJava.August6th.part2_interface.stringProcessor;

public class Apply {
    /**
     * 为什么需要静态方法？
     * @param p
     * @param s
     */
    public static void process(Processor p,Object s){
        System.out.println("Using Processor "+p.name());
        System.out.println(p.process(s));//每一个Processor的process的内容可能都不一样
    }
}
