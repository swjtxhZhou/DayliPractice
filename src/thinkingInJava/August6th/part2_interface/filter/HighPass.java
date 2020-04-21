package thinkingInJava.August6th.part2_interface.filter;

public class HighPass extends Filter{
    double cutOff;
    public HighPass(double cutOff){this.cutOff=cutOff;}
    public Waveform process(Waveform input){return input;}
}
