package August6th.part1_interface.part2_interface;




public abstract class StringProcessor implements Processor{
    public String name(){
        return getClass().getSimpleName();
    }
    public abstract String process(Object input);
    public static String s="if she weights the same as a duck.";
    public static void main(String[] args){
        Apply.process(new Upcase(), s);
        Apply.process(new Downcase(),s);
        Apply.process(new Spliter(),s);
    }
}
