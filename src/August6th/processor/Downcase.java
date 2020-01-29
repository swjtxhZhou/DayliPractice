package August6th.processor;

public class Downcase extends  Processor {
    String process (Object input){
        return ((String)input).toLowerCase();
    }
}
