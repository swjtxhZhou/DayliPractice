package ToOffer.practice;

public class To55_2 {
    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
     * 考察点：平衡二叉树，特点是左子树的高度与右子树的高度的差不超过1。子树同样满足
     * 思路：首先一定会使用递归，到达了一个节点后，计算它的左子树深度和右子树深度，计算二者的差，如果大于了1就返回false。从全局的角度来看应该是自底而上的比较节点的左右子树高度
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null)return true;
        inOrder(root);
        return ret;
    }
    private boolean ret = true;
    private int inOrder(TreeNode root){
        if(root==null||!ret){
            return 0;//自根节点向上计数，如果已经有不平衡了就结束递归
        }
        int left = inOrder(root.left);
        int right = inOrder(root.right);
        if(Math.abs(left-right)>1){
            ret = false;
        }
        return 1+Math.max(left,right);
    }
}
