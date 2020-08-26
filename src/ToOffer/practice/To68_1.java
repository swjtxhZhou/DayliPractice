package ToOffer.practice;

public class To68_1 {
    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * 给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5] p = 2, q = 8
     * 输出: 6
     * 给出的遍历顺序是前序遍历
     * 1、如果两个结点的值一个比root结点大一个比root结点小，那么root结点就是他们的最低公共祖先，因为二叉查找树的特殊性质，左子节点《根节点《右子节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null)return root;
        if(p.val<root.val&&q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(p.val>root.val&&q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}
