package thinkingInJava.August6th.part2_interface.filter;

import thinkingInJava.August6th.part2_interface.stringProcessor.Apply;

public class FilterProcessor {
    public static void main(String[] args){
        Waveform w = new Waveform();
        /**
         * 因为Apply的process方法接接收的第一个参数是Processor，这里是使用了适配器方案的filter
         * 这里的FilterAdapter实现了Processor接口，而适配器的构造器接受了一个filter参数，这样就实现了适配。
         * 因为第二个参数是Object，所以没有任何问题
         */
        Apply.process(new FilterAdapter(new LowPass(1.0)),w);
        Apply.process(new FilterAdapter(new HighPass(2.0)),w);
        Apply.process(new FilterAdapter(new BandPass(3.0,4.0)),w);
    }
}
