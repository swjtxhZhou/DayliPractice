package thinkingInJava.part1.part4;

import java.util.Arrays;

public class AutoboxingArrays {
    public static void main(String[] args){
        Integer[][] a = {{1,2,3,4,5,6,7,8,9,10},{21,22,23,24,25,26,27,28,29,30},{51,52,523,65,45}};
        System.out.println(Arrays.deepToString(a));//Arrays.deepToString()可以将多维数组转换为多个String
    }
}
