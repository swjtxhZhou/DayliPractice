package ToOffer.practice;

import java.util.ArrayList;
import java.util.List;

public class To29_notSimilar {
    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     * 这道题就是要注意各个边界以及转向问题
     *用
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>(16);
        int col = matrix[0].length-1;
        int row = matrix.length-1;
        int c=0,r=0;
        while(c<=col&&r<=row){
            for(int i =c;i<=col;i++){
                res.add(matrix[r][i]);//往左走到尽头
            }
            for(int j=r+1;j<=row;j++){
                res.add(matrix[j][col]);//往下走到尽头
            }
            if(r!=row) {//这个是针对不是正方形的
                for (int i = col - 1; i >= c; i--) {
                    res.add(matrix[row][i]);
                }
            }
            if(c!=col){//这个是针对不是正方形的
                for (int i = row - 1; i > r; i--) {
                    res.add(matrix[i][c]);
                }
            }
            c++;col--;r++;row--;
        }
        return res;

    }

}
