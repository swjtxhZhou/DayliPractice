package ToOffer;

import java.util.ArrayList;

public class Thirty6th {
    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向
     */
    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode root) {
        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        node.left = pre;
        if (pre != null)
            pre.right = node;
        pre = node;
        if (head == null)
            head = node;
        inOrder(node.right);
    }
    //想一下怎么中序遍历二叉树
    /**
     * 先遍历左子树，到达叶子节点了就开始判断
     * 递归遍历的过程中每扫描到一个非空节点，
     * 先判断前驱节点是否为空，若不为空，将该节点的左节点指向前驱节点，将前驱节点的右节点指向当前节点。
     * 将该节点设为前驱节点，
     * 再递归遍历右子树
     */
    private ArrayList<Integer> list = new ArrayList<>();
    public void middleSearch(TreeNode root){
        if(root == null)return;
        middleSearch(root.left);
        list.add(root.val);
        middleSearch(root.right);
    }
}
