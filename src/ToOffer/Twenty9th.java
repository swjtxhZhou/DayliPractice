package ToOffer;

import java.util.ArrayList;
import java.util.List;

public class Twenty9th {
    /**
     * 下图的矩阵顺时针打印结果为：1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10
     *
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();
        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;//r2矩阵行数，c2是矩阵列数、
        //按序将路过的数字放到一个数组里
        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++)//往右走
                ret.add(matrix[r1][i]);
            for (int i = r1 + 1; i <= r2; i++)//往下走
                ret.add(matrix[i][c2]);
            if (r1 != r2)
                for (int i = c2 - 1; i >= c1; i--)//往左走
                    ret.add(matrix[r2][i]);
            if (c1 != c2)
                for (int i = r2 - 1; i > r1; i--)//往上走
                    ret.add(matrix[i][c1]);
            r1++; r2--; c1++; c2--;//将最外层走过的剥掉
        }
        return ret;
    }

    public static void main(String[] args){
        Twenty9th twenty9th = new Twenty9th();
        Twenty9th_practice twenty9th_practice = new Twenty9th_practice();
        List list = new ArrayList();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        list = twenty9th.printMatrix(matrix);
        list = twenty9th_practice.printMatrix(matrix);
        System.out.println(list);


    }
}
