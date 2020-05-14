package ToOffer;

public class Sixty8th {
    /**
     * 树中两个节点的最低公共祖先
     * 在二叉查找树中，两个节点 p, q 的公共祖先 root 满足 root.val >= p.val && root.val <= q.val。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
    /**
     * 在左右子树中查找是否存在 p 或者 q，如果 p 和 q 分别在两个子树中，那么就说明根节点就是最低公共祖先。
     *
     */
    public TreeNode lowestCommonAncestor_commonTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor_commonTree(root.left, p, q);//如果返回值不为空，那么至少p和q至少有一个在该root节点的左子树上
        TreeNode right = lowestCommonAncestor_commonTree(root.right, p, q);//如果返回值不为空，那么至少p和q至少有一个在该root节点的右子树上
        /**
         * 如果left为空，说明左子树上没有p和q，那么可能是在右子树上，但right节点不一定是当前递归的root节点的右节点。
         * 如果left节点不为空，而right节点为空，那么p和q在左子树上，此时left节点不一定是当前递归的root节点的左节点。
         * 如果left节点不为空，right节点也不为空，那么当前递归的root节点就是他们的最低的公共祖先。
         */
        return left == null ? right : right == null ? left : root;//
    }
}
