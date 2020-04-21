package thinkingInJava.part1.part7;

import java.util.Arrays;

public class CopyingArrays {
    public static void main(String[] args){
        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i,47);
        Arrays.fill(j,99);
        System.out.println("i: "+Arrays.toString(i));
        System.out.println("j: "+Arrays.toString(j));
        System.arraycopy(i,0,j,0,i.length);
        /**
         * 需要的参数有，源数组，从源数组什么位置开始复制的偏移量，目标数组，从目标数组的什么位置开始复制的偏移量，以及需要复制的元素个数
         * 它不会执行自动包装和自动拆包，两个数组必须具有相同的确切类型
         */
        System.out.println("j: "+Arrays.toString(j));
        int[] k = new int[5];
        Arrays.fill(k,103);
        System.arraycopy(i,0,k,0,k.length);
        System.out.println("k: "+Arrays.toString(k));

    }
}
