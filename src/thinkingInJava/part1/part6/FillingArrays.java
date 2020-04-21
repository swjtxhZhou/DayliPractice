package thinkingInJava.part1.part6;

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
/**
 * fill方法十分有限，只能用同一个值填充各个位置，而针对对象而言，就是复制一个引用进行填充
 */
        Arrays.fill(a1,true);
        System.out.println(Arrays.toString(a1));

        Arrays.fill(a9,3,5,"World");//只填充数组的某个区域
        System.out.println(Arrays.toString(a9));
    }
}
