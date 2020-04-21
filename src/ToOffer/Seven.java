package ToOffer;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 根据前序序列第一个结点确定根结点
 * 根据根结点在中序序列中的位置分割出左右两个子序列
 * 对左子树和右子树分别递归使用同样的方法继续分解
 */
public class Seven {
    /**
     * 创建一个二叉树的类
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] mid){
        /**
         * Arrays.copyOfRange(T[ ] original,int from,int to)
         * 将一个原始的数组original，从下标from开始复制，复制到上标to，生成一个新的数组。
         * 注意这里包括下标from，不包括上标to
         */
        if(pre.length == 0 || mid.length==0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for(int i =0; i<mid.length;i++){
            if(mid[i] == pre[0]){
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(mid,0,i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(mid,i+1,mid.length));
            }
        }
        return root;
    }
    public static void main(String[] args){
        Seven seven = new Seven();
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] mid = new int[]{4,7,2,1,5,3,8,6};
        seven.reConstructBinaryTree(pre,mid);
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}
