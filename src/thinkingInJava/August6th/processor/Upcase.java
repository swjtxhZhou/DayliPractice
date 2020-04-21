package thinkingInJava.August6th.processor;

public class Upcase extends Processor {
    /**
     * 把传入的字符串里的内容全部转换为大写的状态
     * @param input
     * @return
     */
    String process(Object input){
        return ((String)input).toUpperCase();
    }

}
