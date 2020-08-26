package 面前练习.美团点评8_22面前练习;

import ToOffer.Utils.ListNode;
import ToOffer.Utils.TreeNode;

public class AboutBinaryTree {
    /**
     * 翻转二叉树
     */
    public static void reverseBinaryTree(TreeNode node){
        if(node==null){
            return;
        }
//        node.left = reverseBinaryTree(node.right);
//        node.right = reverseBinaryTree(node.left);
        //选翻转根节点，再分别翻转左右节点
        swap(node);
        reverseBinaryTree(node.left);
        reverseBinaryTree(node.right);
    }
    public static void swap(TreeNode node){
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
    /**
     * 在二叉树中找到最近公共祖先
     */
    //普通二叉树
    public static TreeNode findCommonAncestry(TreeNode root,TreeNode node1,TreeNode node2){
        //从根节点往下找，如果两个节点分别在节点的左右子树，那么根节点就是公共祖先。否则递归
         if(root==null||root==node1||root==node2){
             //如果当前节点为空或者当前节点等于两个节点中的其中一个，则返回当前节点
             return root;
         }
         TreeNode left = findCommonAncestry(root.left,node1,node2);
         TreeNode right = findCommonAncestry(root.right,node1,node2);

         return left==null?right:right!=null?root:left;
    }

}
