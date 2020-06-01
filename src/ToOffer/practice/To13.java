package ToOffer.practice;

public class To13 {
    /**
     * 地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，每一次只能向左右上下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
     *
     * 例如，当 k 为 18 时，机器人能够进入方格 (35,37)，因为 3+5+3+7=18。但是，它不能进入方格 (35,38)，因为 3+5+3+8=19。请问该机器人能够达到多少个格子？
     */
    /**
     *这个和之前的回溯很相似，用的是深度搜索模式，可以设置一个全局变量来操作
     * 题干有特殊的条件，需要一开始就对全局的行做标列坐标的数位之和保存到一个二维数组中
     */
    private int col;
    private int row;
    private int[][] matrixNum;
    private int threshold;
    private int cnt;
    private int[][] direct={{-1,0},{1,0},{0,-1},{0,1}};
    public int movingCount(int threshold, int rows, int cols)
    {
        this.row = rows;
        this.col = cols;
        this.threshold = threshold;
        boolean[][] marked = new boolean[row][col];
        initDigitSum();
        dfs(marked,0,0);
        return cnt;
    }
    //需要的参数，行列的位置，标志位
    private void dfs(boolean[][] marked,int col,int row){
        //终止条件，判断标志位，判断边界(要先判断边界)
        //有一个失误，这里如果col等于col边界也不行，因为索引位从0开始的
        if(col<0||col>=this.col||row<0||row>=this.row||marked[row][col]){
            return;
        }
        //判断是否满足门槛条件，不管满足还是不满足都要打上标志
        marked[row][col]=true;
        if(matrixNum[row][col]>threshold){
            return;
        }
        cnt++;
        //尝试往四个方向走
        for(int[] next:direct){
            dfs(marked,col+next[1],row+next[0]);
        }
    }
    private void initDigitSum(){
        int[] digitOne = new int[Math.max(row,col)];
        for(int i=0;i<digitOne.length;i++){
            int n=i;//这是需要拆分数位的目标
            while(n>0){
                digitOne[i]+=n%10;//取最小的位的数
                n/=10;//去掉最小位
            }
        }
        this.matrixNum = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                matrixNum[i][j]=digitOne[i]+digitOne[j];
            }
        }
    }
    public static void main(String[] args){
        To13 to13=new To13();
        System.out.println(to13.movingCount(15,20,20));
    }
}
