package August6th.part1_interface.part2_interface;

public class FilterProcessor {
    public static void main(String[] args){
        Waveform w = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)),w);
        Apply.process(new FilterAdapter(new HighPass(2.0)),w);
        Apply.process(new FilterAdapter(new BandPass(3.0,4.0)),w);
    }
}
