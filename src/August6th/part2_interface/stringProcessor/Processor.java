package August6th.part2_interface.stringProcessor;

/**
 * 直接把Processor当作一个接口，之前Processor是一个类
 */
public interface Processor {
    String name();
    Object process(Object input);
}
