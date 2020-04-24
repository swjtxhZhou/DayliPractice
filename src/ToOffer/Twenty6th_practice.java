package ToOffer;

import com.sun.source.tree.Tree;

public class Twenty6th_practice {
    /**
     * 查找子树
     */
    public boolean hasSubtree(TreeNode root,TreeNode targetRoot){
        if(root==null||targetRoot==null){
            return false;
        }
        return isSubtreeWithRoot(root,targetRoot) || isSubtreeWithRoot(root.left,targetRoot)||isSubtreeWithRoot(root.right,targetRoot);
    }
    public boolean isSubtreeWithRoot(TreeNode root,TreeNode targetRoot){
        if(targetRoot == null){
            return true;
        }
        if(root == null){
            return false;
        }
        if(root.val != targetRoot.val){
            return false;
        }
        return isSubtreeWithRoot(root.left,targetRoot.left) && isSubtreeWithRoot(root.right,targetRoot.right);
    }
}
