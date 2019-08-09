package August6th.part1_interface.part2_interface;

/**
 * 适配器设计方式
 */
public class FilterAdapter implements Processor{
    Filter filter;
    public FilterAdapter(Filter filter){
        this.filter = filter;
    }
    public String name(){
        return filter.name();
    }
    public Waveform process(Object input){
        return filter.process((Waveform)input);
    }
}
