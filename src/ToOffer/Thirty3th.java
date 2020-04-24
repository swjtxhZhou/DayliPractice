package ToOffer;

public class Thirty3th {
    /**
     * 二叉搜索树的后序遍历序列
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。假设输入的数组的任意两个数字都互不相同。
     *
     * BST（Binary Search Tree）目的是为了提高查找的性能，其查找在平均和最坏的情况下都是logn级别，接近二分查找。
     * 其特点是：每个节点的值大于其任意左侧子节点的值，小于其任意右节点的值。
     * 例如，下图是后序遍历序列 1,3,2 所对应的二叉搜索树。
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return verify(sequence, 0, sequence.length - 1);//传入参数，数组，数组第一个值的位置最后一个值的位置
    }

    private boolean verify(int[] sequence, int first, int last) {
        if (last - first <= 1)//如果只有两个数，绝对可以组成二叉搜索树
            return true;
        int rootVal = sequence[last];//这是根节点，根据根节点把左子树和右子树分开
        int cutIndex = first;
        //将左右子树割裂开
        //计算在哪个位置将数组分开
        while (cutIndex < last && sequence[cutIndex] <= rootVal)//
            cutIndex++;
        for (int i = cutIndex; i < last; i++)//比较后面这部分是不是都比根节点大，如果不是则就不是二叉搜索树
            if (sequence[i] < rootVal)
                return false;
        return verify(sequence, first, cutIndex - 1) && verify(sequence, cutIndex, last - 1);
    }
}
