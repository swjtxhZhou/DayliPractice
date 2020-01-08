package test;

import java.util.Arrays;

public class KMPAlgorithm {
    public static void main(String[] args){
        String test = "ABCDABD";
        int[] next = KMPNext(test);
        System.out.println(Arrays.toString(next));
    }
    public static int[] KMPNext(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;
        for(int i =1,j=0;i<dest.length();i++){

            if(j>0 && dest.charAt(i)!=dest.charAt(j)){
                j = next[j-1];
            }
            if(dest.charAt(i)==dest.charAt(j)){
                j++;
            }
            next[i]=j;

        }
        return next;
    }
}
