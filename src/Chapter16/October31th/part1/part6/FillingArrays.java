package Chapter16.October31th.part1.part6;

import java.util.Arrays;

public class FillingArrays {
    public static void main(String[] args){
        int size= 6;
        boolean[] a1 = new boolean[size];
        byte[] a2= new byte[size];
        char[] a3 = new char[size];
        short[] a4 = new short[size];
        int[] a5 = new int[size];
        long[] a6 = new long[size];
        float[] a7 = new float[size];
        double[] a8 = new double[size];
        String[] a9 = new String[size];

        Arrays.fill(a1,true);
        System.out.println(Arrays.toString(a1));

        Arrays.fill(a9,3,5,"World");
        System.out.println(Arrays.toString(a9));
    }
}
