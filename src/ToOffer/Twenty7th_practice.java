package ToOffer;

public class Twenty7th_practice {
    public void Mirro(TreeNode root){
        if(root == null){
            return;
        }
        swap(root);
        Mirro(root.left);
        Mirro(root.right);
    }
    public void swap(TreeNode root){
        TreeNode index = root.left;
        root.left = root.right;
        root.right = index;
    }
}
