package August6th.part1_interface;

public class Upcase extends Processor {
    String process(Object input){
        return ((String)input).toUpperCase();
    }

}
