package ToOffer;

public class Twenty6th {
    /**
     *树的子结构
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        //先判断该树是不是目标树，再从左子树开始搜寻，接着搜寻右子树
        return isSubtreeWithRoot(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2) {
        if (root2 == null)//查询的目标子树对比完了，返回查询成功
            return true;
        if (root1 == null)//主树搜寻完了，目标子树还没有搜寻完，返回失败
            return false;
        if (root1.val != root2.val)//匹配主树与子树的值不成功返回匹配失败
            return false;
        return isSubtreeWithRoot(root1.left, root2.left) && isSubtreeWithRoot(root1.right, root2.right);
    }
}
