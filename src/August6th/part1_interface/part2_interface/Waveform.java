package August6th.part1_interface.part2_interface;

public class Waveform {
    private static long counter;
    private final long id = counter++;
    public String toString(){return "Waveform"+id;}
}
