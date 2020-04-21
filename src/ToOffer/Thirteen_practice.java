package ToOffer;
//深度优先搜索与回溯算法有所不同，只会有少部分的局部变量，最多会回溯一步
public class Thirteen_practice {
    int rows;
    int cols;
    boolean[][] marked;
    int threshold;
    int[][] digitSumOne;
    int cnt;
    int[][] next = {{1,0},{-1,0},{0,1},{0,-1}};

    //需要调用的主要函数
    public int movingCount(int rows,int cols,int threshold){
        this.cols=cols;
        this.rows=rows;
        this.threshold = threshold;
        this.marked = new boolean[rows][cols];
        digitSum();
        dfs(0,0,marked);//从（0，0）开始走，局部变量只有标志变量
        return cnt;
    }

    //深度优先搜索
    private void dfs(int rows,int cols,boolean[][] marked){
        if(rows<0||rows>this.rows||cols<0||cols>this.cols||marked[rows][cols]){
            return;//这个格子已经走过了，或者超出了大方格的范围
        }
        marked[rows][cols]= true;//尝试去走这个格子，最后不一定能走通
        if(digitSumOne[rows][cols]>this.threshold){
            return;//这个格子走不通，但是需要标记已经走过
        }
        //这个格子能走通，开始往这个格子的四个方向试探
        for(int[] n:next){
            dfs(rows+n[0],cols+n[1],marked);
        }
    }

    public void digitSum(){
        int[] digitSumOne = new int[Math.max(rows,cols)];
        //算每个位置上数字之和
        for(int i=0;i<digitSumOne.length;i++){
            int n = i;
            while(n>0){
                digitSumOne[i] += n%10;
                n /= 10;
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                this.digitSumOne[i][j] = digitSumOne[i]+digitSumOne[j];
            }
        }
    }
}
