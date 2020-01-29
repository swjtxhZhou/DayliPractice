package August6th.part2_interface.filter;

/**
 * 带宽
 */
public class BandPass extends Filter{
    double lowCutoff,highCutoff;
    public BandPass(double lowCutoff,double highCutoff){
        this.lowCutoff=lowCutoff;
        this.highCutoff=highCutoff;
    }
    public Waveform process(Waveform input){
        return input;
    }
}
