package August6th.part1_interface.part2_interface;

public class HighPass extends Filter{
    double cutOff;
    public HighPass(double cutOff){this.cutOff=cutOff;}
    public Waveform process(Waveform input){return input;}
}
