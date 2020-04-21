package thinkingInJava.part1.part7;

import java.util.Arrays;

public class ComparingArrays {
    public static void main(String[] args){
        int[] a1 = new  int[10];
        int[] a2 = new int[10];
        Arrays.fill(a1,10);
        Arrays.fill(a2,10);
        System.out.println(Arrays.equals(a1,a2));
        /**
         * 数组相等的条件是元素个数必须相等，并且对应位置的元素也相等。
         */
        a2[3] = 0;
        System.out.println(Arrays.equals(a1,a2));
    }
}
