package ToOffer;

public class Fifth5th_2nd {
    /**
     * 平衡二叉树
     * 平衡二叉树左右子树高度差不超过 1。
     * 判断一个树是否是平衡二叉树
     * 平衡二叉树的左右子树也是平衡二叉树，那么所谓平衡就是左右子树的高度差不超过1.
     */
    private boolean result;
    private int Depth(TreeNode node){
         //先判断是否到了根节点
        if(node == null)return 0;
        //左节点的深度
        int left=Depth(node.left);
        //若该节点的左子树已经不平衡了不需要继续进项高度求解了
        if(left==-1)return -1;
        //右节点的深度
        int right = Depth(node.right);
        //若该节点的右子树已经不平衡了不需要继续进行高度求解了
        if(right==-1)return -1;
        //判断左树和右树的高度差，若大于
        if(right-left<(-1)||right-left>1){
            return -1;
        }else{
            return 1 + (left>right?left:right);
        }

    }
    public boolean IsBanlancedTree(TreeNode root){
        Depth(root);
        return result;
    }
}
