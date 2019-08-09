package August6th.part1_interface;

public class Downcase extends  Processor {
    String process (Object input){
        return ((String)input).toLowerCase();
    }
}
