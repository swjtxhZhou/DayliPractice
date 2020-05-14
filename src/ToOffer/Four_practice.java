package ToOffer;

public class Four_practice {
    /**
     * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中
     *
     * 该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间，当前元素的查找区间为左下角的所有元素。
     */
    public boolean Find(int[][] matrix,int target){
        //这里从右上角开始找而不是左上角
        int row=matrix.length,i=0,j=matrix[0].length-1;
        //这里while的判断条件应该是控制边界的范围
        while(i<=row-1 && j>=0){
            //找到目标值
            if(matrix[i][j]==target){
                   return true;
            }
            //目标值比当前值小，往下走
            if(target<matrix[i][j]){
                i++;
            }
            //目标值比当前值大，往左走
            if(target>matrix[i][j]){
                j--;
            }
        }

        return false;
    }
}
