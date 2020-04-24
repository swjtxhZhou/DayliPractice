package ToOffer;

import java.util.ArrayList;
import java.util.List;

public class Twenty9th_practice {
    /**
     * 顺时针打印矩阵
     */
    public ArrayList<Integer> printMatrix(int[][] matrix){
        ArrayList<Integer> ret = new ArrayList<>();
        int r1 = 0,r2 = matrix.length-1,c1 = 0, c2 = matrix[0].length-1;
        while(r1<=r2&&c1<=c2){
            for(int i=c1;i<=r2;i++){
                ret.add(matrix[r1][i]);
            }
            for(int i=r1+1;i<=c2;i++){
                ret.add(matrix[i][c2]);
            }
            if(r1!=r2){
                for(int i=c2-1;i>=c1;i--){//这里用的c2-1是避免将拐角处的数字重复添加
                    ret.add(matrix[c2][i]);
                }
            }
            if(c1!=c2){
                for(int i=r2-1;i>r1;i--){//r2-1也是避免重复添加拐角处的数字
                    ret.add(matrix[i][r2]);
                }
            }
            r1++;r2--;c1++;c2--;
        }
        return ret;
    }
}
