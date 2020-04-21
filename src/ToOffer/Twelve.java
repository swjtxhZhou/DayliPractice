package ToOffer;

public class Twelve {
    /**
     * 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向上下左右移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
     */
    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};//表示可以走上下左右四个方向
    private int rows;//行
    private int cols;//列

    /**
     * 主要的函数，
     * @param array 需要构造的字符格子
     * @param rows 方格的行数
     * @param cols 方格的列数额
     * @param str 传入的字符串
     * @return 返回结果为true 或者false
     * 1、先对传入的参数进行判断，看是否满足要求
     * 2、设置一个全局的标志变量，用来存储走过的痕迹
     */
    public boolean hasPath(char[] array, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0) return false;
        this.rows = rows;//为什么要使用类属性，不使用传入的参数
        this.cols = cols;
        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix = buildMatrix(array);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (backtracking(matrix, str, marked, 0, i, j))
                    return true;

        return false;
    }

    /**
     * 回溯算法
     * @param matrix
     * @param str
     * @param marked
     * @param pathLen
     * @param r
     * @param c
     * @return
     */
    private boolean backtracking(char[][] matrix, char[] str,
                                 boolean[][] marked, int pathLen, int r, int c) {

        if (pathLen == str.length) return true;//已经走完了需要走的字符，则寻找成功
        if (r < 0 || r >= rows || c < 0 || c >= cols//1、超出了范围2、字符不符合要求3、重复走
                || matrix[r][c] != str[pathLen] || marked[r][c]) {

            return false;
        }
        marked[r][c] = true;//先将当前走的格子标记为true，但并不表示已经走过
        for (int[] n : next)//next中包含了四个方向
            if (backtracking(matrix, str, marked, pathLen + 1, r + n[0], c + n[1]))
                return true;
        marked[r][c] = false;//如果这次寻找失败，把该次标志位去除，往回回溯
        return false;
    }

    private char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        for (int r = 0, idx = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                matrix[r][c] = array[idx++];
        return matrix;
    }

}
