package Chapter16.October31th.part1.part4;

import java.util.Arrays;
import java.util.Random;

public class MutidimensionalPrimitiveArray {
    public static void main(String[] args){
        int[][] a = {
                {1,2,3},{4,5,6}
        };
        System.out.println(Arrays.deepToString(a));//Arrays.deepToString()可以将多维数组转换为多个String
        System.out.println(a);//打印出来地址

        int[][][] b= new int[2][2][4];
        System.out.println(Arrays.deepToString(b));
        System.out.println(b);

        Random rand = new Random(47);
        int[][][] c = new int[rand.nextInt(7)][][];
        for(int i=0;i<c.length;i++){
            c[i] = new int[rand.nextInt(5)][];
            for(int j=0;j<c[i].length;j++){
                c[i][j] = new int[rand.nextInt(5)];
            }
        }
        System.out.println(Arrays.deepToString(c));
    }
}
