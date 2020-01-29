package August6th.part2_interface.stringProcessor;

/**
 * 继承了抽象类，需要实现继承方法
 * 因为继承了StringProcessor，所以不需要单独实现name（）方法和process（）方法。因为这两个方法在几个需要使用的类里面是相同的，这减少了代码冗余
 */
public class Upcase extends StringProcessor {
    public String process(Object input){
        return ((String)input).toUpperCase();
    }
}
