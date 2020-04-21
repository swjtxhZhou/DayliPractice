package thinkingInJava.August6th.part2_interface.stringProcessor;

/**
 * 只含一个抽象方法也是抽象类，抽象类也可以有main函数
 *
 */
public abstract class StringProcessor implements Processor{
    public String name(){
        return getClass().getSimpleName();
    }
    public abstract String process(Object input);
    public static String s="if she weights the same as a duck.";
    public static void main(String[] args){
        /**
         * apply的process方法是一个静态方法，apply若是在同一个包里面就可以直接调用，否则必须使用import static来导入
         */
        Apply.process(new Upcase(), s);
        Apply.process(new Downcase(),s);
        Apply.process(new Spliter(),s);
    }
}
