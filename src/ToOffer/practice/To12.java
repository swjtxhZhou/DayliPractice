package ToOffer.practice;

public class To12 {
    /**
     * 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向上下左右移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
     */
    private int row;
    private int col;
    private final int[][] index={{-1,0},{1,0},{0,-1},{0,1}};//上下左右
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
       //需要把matrix转换成一个二维数组
        this.row = rows;
        this.col = cols;
        char[][] mat = buildMatrix(matrix);
        boolean[][] marked = new boolean[row][col];//用来标注哪些地方走过了
        //需要从字符数组的每个位置都定义一次出发位置
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(backTracking(mat,marked,0,str,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    //参数分别是，char数组，标记为，走到目标字符的那个我位置，目标字符串，走到了字符数组的哪个位置
    private boolean backTracking(char[][] mat,boolean[][] marked,int pathLen,char[] str,int r,int c){
        //回溯的往回走的判断
        if(pathLen==str.length){
            return true;
        }
        //判断这个格子是否可以走,边界判断，目标字符判断，标注判断
        if(r>row-1||r<0||c<0||c>col-1||marked[r][c]||mat[r][c]!=str[pathLen]){
            return false;
        }
        //可以标注这个格子
        marked[r][c]=true;
        //接下来往各个方向走
        for(int[] next:index){
            if(backTracking(mat,marked,pathLen+1,str,r+next[0],c+next[1])){
                return true;
            }
        }//如果四个方向都走不通，去掉这个格子的标志位,往回回溯，如果不去掉标志位会有问题，回溯后的其他路线就不能再走这个格子，逻辑不正确。
        marked[r][c]=false;
        return false;
    }
    private char[][] buildMatrix(char[] array){
        char[][] matrix = new char[row][col];
        for(int i=0,index=0;i<row;i++){
            for(int j=0;j<col;j++){
                matrix[i][j]=array[index++];
            }
        }
        return matrix;
    }
}
