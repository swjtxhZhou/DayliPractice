package ToOffer;

import static Utils.StringUtils.*;
import java.util.Random;

/**
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中
 *
 * 该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间，当前元素的查找区间为左下角的所有元素。
 */
public class Four {
    public boolean Find(int[][] matrix,int target){
        int row = matrix.length;//总的行数
        int col = matrix[0].length;//总的列数
        int i = 0;//行row
        int j = matrix[0].length-1;//列col
        //从右上角开始
        while(i <= row-1 && j>= 0) {//因为是从0开始数，所以是row-1,必须是要两个都为真才继续循环
            if (target == matrix[i][j]) {//找到目标值
                return true;
            }
            else if (target > matrix[i][j]) {//如果大于目标值往左走,就是列递减
                j--;
            }
            else if(target <matrix[i][j]){//如果小于目标值往下走，就是行递加
                i++;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Random rand = new Random(47);
        int[][] matrix = new int[100][100];
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                matrix[i][j] = rand.nextInt(100);
            }
        }
        Four four = new Four();
        println("find target:"+four.Find(matrix,55));
    }
}
