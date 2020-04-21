package thinkingInJava.August19th;

import java.util.Arrays;

public class AdapterMethodIdiom {
    public static void main(String[] args){
        ReversibleArrayList<String> ral = new ReversibleArrayList<String>(Arrays.asList("to be or not to be".split(" ")));
        for(String s:ral){
            System.out.print(s+" ");
        }
        for(String s:ral.reversed()){
            System.out.print(s+" ");
        }
    }
}
