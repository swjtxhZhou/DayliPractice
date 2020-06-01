package ToOffer;

import ToOffer.Utils.TreeNode;

public class Fifty4th {
    /**
     * 二叉查找树的第 K 个结点
     * 1.若它的左子树不为空，则左子树上所有结点的值均小于等于根结点的值；
     * 2.若它的右子树不为空，则右子树上所有结点的值均大于等于根结点的值；
     * 3.它的左右子树均为二分查找树。
     * 中序遍历是有序的
     */
    private int cnt=0;
    private TreeNode target;

    public TreeNode KthNode(TreeNode rNode,int k){
        inOrder(rNode, k);
        return target;
    }
    public void inOrder(TreeNode node,int k){
        if(node==null||cnt>=k){return;}
        //先是遍历左子树
        inOrder(node.left,k);
        //判断是不是到k了
        cnt++;
        if(cnt == k){
            target = node;
        }
        //再遍历左子树
        inOrder(node.right,k);

    }
}
