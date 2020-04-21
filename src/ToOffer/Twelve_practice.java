package ToOffer;

public class Twelve_practice {
    private final static int[][] next={{1,0},{-1,0},{0,1},{0,-1}};//一个数组存放四个方向的走法
    char[][] marked;//全局走过的标志
    int rows;
    int cols;

    //主函数
    public boolean solution(char[] array,int r,int c,char[] str){
        if(r<0 || c<0){return false;}
        char[][] matrix = buildMatrix(array,r,c);
        this.rows = r;
        this.cols = c;
        boolean[][] marked = new boolean[r][c];
        for(int i = 0;i<r;i++){//每一个格子都当作一个起点来走一次，看能不能走通。
            for(int j = 0; j<c;j++){
                if(hasPath(matrix,i,j,0,marked,str)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean hasPath(char[][] matrix,int r,int c,int pathLen,boolean[][] marked,char[] str){
        if(pathLen == str.length)return true;
        if(r>rows || r<0 || c>cols || c<0 || matrix[r][c] != str[pathLen] || marked[r][c]){
            return false;
        }
        marked[r][c] = true;//这一步能走通，但是不表明下一步能走通
        for(int[] a:next){
            if(hasPath(matrix,r+a[0],c+a[1],pathLen+1,marked,str)){
                return true;
            }
        }
        marked[r][c] = false;
        return false;
    }
    private char[][] buildMatrix(char[] array ,int r,int c){
        char[][] matrix = new char[r][c];
        int index =0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                matrix[i][j] = array[index++];
            }
        }
        return matrix;
    }
}
