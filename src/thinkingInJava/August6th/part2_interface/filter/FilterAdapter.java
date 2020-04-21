package thinkingInJava.August6th.part2_interface.filter;

import thinkingInJava.August6th.part2_interface.stringProcessor.Processor;

/**
 * 适配器设计方式
 */
public class FilterAdapter implements Processor {
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
