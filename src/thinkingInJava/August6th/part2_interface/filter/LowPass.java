package thinkingInJava.August6th.part2_interface.filter;

public class LowPass extends Filter{
    double cutOff;
    public LowPass(double cutOff){this.cutOff=cutOff;}
    public Waveform process(Waveform input){
        return input;
    }
}
