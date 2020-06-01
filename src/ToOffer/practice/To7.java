package ToOffer.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class To7 {
    /**
     * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     * 前序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，左部分为树的左子树中序遍历结果，右部分为树的右子树中序遍历的结果。然后分别对左右子树递归地求解。
     */
    private Map<Integer,Integer> IndexOfInorder =new HashMap<>();
    public TreeNode reConstructBinaryTree_cyc(int [] pre,int [] in) {
        for(int i=0;i<in.length;i++){
            IndexOfInorder.put(in[i],i);
        }
        return reConstructBinaryTree(pre,0,pre.length-1,0);
    }
    private TreeNode reConstructBinaryTree(int[] pre,int preL,int preR,int inL){
        if(preL>preR){
            return null;
        }
        TreeNode root=new TreeNode(pre[preL]);//每次递归的根节点
        //根据根节点，把根节点在中序遍历的什么位置找出来
        int inIndex = IndexOfInorder.get(root.val);
        //得到左子树的长度
        int leftTreeSize = inIndex-inL;
        //第二个参数是确定下一个子树的根节点的位置，第三个参数是子树的右边界
        root.left = reConstructBinaryTree(pre,preL+1,preL+leftTreeSize,inL);
        root.right = reConstructBinaryTree(pre,preL+leftTreeSize+1,preR,inL+leftTreeSize+1);
        return root;
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in){
        if(pre.length==0||in.length==0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for(int i=0;i<in.length;i++){
            if(in[i]==pre[0]){
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return root;
    }
}
