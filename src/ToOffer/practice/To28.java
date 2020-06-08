package ToOffer.practice;

public class To28 {
    /**
     * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     *根节点的左节点和右节点相同
     * 左节点的左节点和右节点的右节点相同，左节点的右节点和右节点的左节点相同
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null)return true;
        return isSym(pRoot.left,pRoot.right);

    }
    private boolean isSym(TreeNode t1,TreeNode t2){
        if(t1==null&&t2==null){return true;}
        if(t1==null||t2==null)return false;//两个需要对比的节点不是同时为空，则不是对称的二叉树
        if(t1.val!=t2.val)return false;//两个需要比较的节点的值不是相同的，不是对称的二叉树
        return isSym(t1.left,t2.right) && isSym(t1.right,t2.left);
    }
}
