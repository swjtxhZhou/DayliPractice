package ToOffer.practice;

public class To68_2 {
    /**
     * 把68_1的树换成普通二叉树，就不能通过两个结点的值取判断祖先结点
     * 自己的想法是从下往上找，但是往上的步长是不能统一的，这种思想做不出来
     * 题解思考：
     * 1、从上往下找
     * 2、分别在左右子树都找，如果分别在左右子树那么祖先结点就是根节点
     * 3、如果只在其中一个子树中，将这个树又当成一个新书继续上面的步骤
     * 4、递归终止条件是结点为空，结点等于目标结点之一
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //这一句可以表示为，如果左节点没有返回值那么返回右节点的返回值，如果右节点没有返回值
        if(left==null&&right==null)return root;
        if(left==null)return right;
        if(right==null)return left;

        return left==null?right:right==null?left:root;
    }
}
