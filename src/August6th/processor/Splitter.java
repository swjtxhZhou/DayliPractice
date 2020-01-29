package August6th.processor;

import java.util.Arrays;

public class Splitter extends Processor {
    /**
     * 将一条字符串通过空格转换为多条字符串
     * @param input
     * @return
     */
    String process(Object input){
        return Arrays.toString(((String)input).split(" "));
    }
}
