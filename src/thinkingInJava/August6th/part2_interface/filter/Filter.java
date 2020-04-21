package thinkingInJava.August6th.part2_interface.filter;

public class Filter {
    public String name(){
        return getClass().getSimpleName();
    }
    public Waveform process(Waveform input){
        return input;
    }
}
