package Chapter16.October31th.part1.part3;

import java.util.Arrays;
import java.util.Random;

public class Icecream {
    private static Random rand = new Random(47);
    static final String[] FLAVORS = {
            "Chocolate","Strawberry","Vanilla Fudge Swirl","Mint Chip","Mocha Almond Fudge","Rum Raisin","Praline Cream","Mud pie"
    };
    public static String[] flavorSet(int n){//传入的n为数组中存放味道的数量
        if(n > FLAVORS.length){
            throw new IllegalArgumentException("set too big");
        }
        String[] results = new String[n];
        boolean[] picked = new boolean[FLAVORS.length];
        for(int i =0; i<n;i++){
            int t ;
            do {
                t = rand.nextInt(FLAVORS.length);
            }
            while(picked[t]);//确保当前数组的味道不会重复
            results[i] = FLAVORS[t];
            picked[t] = true;
        }
        return results;
    }
    public static void main(String[] args){
        for(int i=0;i<7;i++){
            System.out.println(Arrays.toString(flavorSet(2)));
        }
    }
}
