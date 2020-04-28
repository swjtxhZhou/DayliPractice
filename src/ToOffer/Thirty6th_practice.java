package ToOffer;

public class Thirty6th_practice {
    private TreeNode pre = null;
    private TreeNode head = null;
    public TreeNode Convert(TreeNode root){
        Order(root);
        return head;

    }
    private void Order(TreeNode node){
        if(node == null){return;}
        Order(node.left);
        node.left = pre;
        if(pre != null){
            pre.right = node;
        }
        pre = node;
        if(head == null){
            head = node;
        }
        Order(node.right);
    }
}
