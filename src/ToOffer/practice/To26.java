package ToOffer.practice;

import ToOffer.Utils.ListNode;

public class To26 {
    /**
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     * 递归，一开始象得想的是把根节点的左右子节点保存下来，然后交替赋值，但是递归函数是无返回值的，这里就不好实现
     * 这里交换的功能在一个新的函数里实现
     */
    public void Mirror(TreeNode root) {
        if(root==null){return;}
//        swap(root);
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        Mirror(root.left);
        Mirror(root.right);

    }
    private void swap(TreeNode root){
        TreeNode t =  root.left;
        root.left = root.right;
        root.right = t;
    }
}
