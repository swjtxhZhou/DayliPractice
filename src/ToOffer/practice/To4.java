package ToOffer.practice;

public class To4 {
    //在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

    /**
     * 从右上角出发，往左是减少，往下是增加
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        if(array==null||array.length==0||array[0].length==0){
            return false;
        }
        int row = array.length;
        int i=0,j=array[0].length-1;
        while(i<=row-1&&j>=0){//控制范围
            if(array[i][j]<target){
                i++;
            }else if(array[i][j]>target){
                j--;
            }else if(array[i][j]==target){
                return true;
            }
        }
        return false;
    }
}
