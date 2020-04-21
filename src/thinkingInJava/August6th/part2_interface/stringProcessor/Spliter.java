package thinkingInJava.August6th.part2_interface.stringProcessor;

import java.util.Arrays;

public class Spliter extends StringProcessor{
    public String process(Object input){
        return Arrays.toString(((String)input).split(" "));
    }
}
