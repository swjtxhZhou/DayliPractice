package August6th.part1_interface.part2_interface;

public class LowPass extends Filter{
    double cutOff;
    public LowPass(double cutOff){this.cutOff=cutOff;}
    public Waveform process(Waveform input){
        return input;
    }
}
