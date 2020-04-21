package thinkingInJava.part2.part9th;

import java.util.Random;

public class Prediction {
    private static Random rand = new Random(47);
    private boolean shadow = rand.nextDouble()>0.5;
    public String toString(){
        if(shadow){
            return "six more of winter";
        }else{
            return "early spring";
        }
    }
}
