package ToOffer.practice;

public class To36 {
    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
     *
     *二叉搜索树的中序遍历就是有序的数组，
     * 将树转换成双向链表就是要调整一个节点的两个左右指针
     *
     */
    private TreeNode head=null;
    private TreeNode pre = null;//遍历到的节点的上一个节点
    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;
    }
    private void inOrder(TreeNode node){
        if(node == null)return;
        //中序遍历
        inOrder(node.left);
        if(head==null){
            head = node;
        }
        node.left = pre;//当前节点的的左子树指向上一个遍历到的节点（比它小的值）
        if(pre!=null){
            pre.right = node;//上一个节点的右节点指向当前节点（比它大的值）
        }
        pre = node;//令当前节点成为上一个节点
        inOrder(node.right);
    }
}
