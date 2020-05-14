package ToOffer;

public class Sixty8th_practice {
    public TreeNode LowestCommonAncestra(TreeNode root,TreeNode p,TreeNode q){
        if(root == null){
            return root;//只是在刚进入方法时这句判断才管作用
        }
        if(p.val>root.val && q.val>root.val){
            return LowestCommonAncestra(root.right,p,q);
        }//p和q都在root的左子树上
        if(p.val<root.val && q.val<root.val){//p和q都在root的右子树上
            return LowestCommonAncestra(root.left,p,q);
        }
        return root;
    }

    public TreeNode LowestCommonAncestra_commonTree(TreeNode root,TreeNode p,TreeNode q){
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = LowestCommonAncestra_commonTree(root.left,p,q);
        TreeNode right = LowestCommonAncestra_commonTree(root.right,p,q);
        return left==null?right:right==null?root:null;

    }
}
