package thinkingInJava.August6th.part2_interface.stringProcessor;

public class Downcase extends StringProcessor{
    public String process(Object input){
        return ((String)input).toLowerCase();
    }
}
