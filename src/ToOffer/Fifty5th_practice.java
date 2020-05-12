package ToOffer;

public class Fifty5th_practice {
    /**
     * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     */
    public int TreeDepth(TreeNode node){
        return node==null?0:1+Math.max(TreeDepth(node.left),TreeDepth(node.right));
    }
}
