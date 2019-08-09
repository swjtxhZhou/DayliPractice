package August6th.part1_interface.part2_interface;

import java.util.Arrays;

public class Spliter extends StringProcessor{
    public String process(Object input){
        return Arrays.toString(((String)input).split(" "));
    }
}
