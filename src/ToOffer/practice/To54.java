package ToOffer.practice;

import ToOffer.Utils.ListNode;

import java.util.ArrayList;

public class To54 {
    /**
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
     * 二叉搜索树中序遍历就是有序的，二叉搜索树的特性就是左节点>根节点>右节点
     * 题干意思就是找到中序遍历的第三个节点的值.可以全部打印出来再找第几小
     * 优化方案，用一个额外内存来记录递归了几次，如果超过次数就停止递归，提高时间复杂度，虽然都是O（n）.
     */
    //用递归试一试
    ArrayList<TreeNode> list = new ArrayList<>();
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(k==0)return null;
        printNode(pRoot);
        return k>list.size()?null:list.get(k-1);
    }

    private void printNode(TreeNode pRoot){
        if(pRoot==null)return;
        printNode(pRoot.left);
        list.add(pRoot);
        printNode(pRoot.right);
    }
    //优化方案,当递归次数达到了次数就不用再遍历完整棵树了，虽然时间复杂度还是O（N）
    int cnt =0;
    TreeNode ret = null;
    TreeNode KthNode_optimal(TreeNode pRoot,int k){
        if(k==0)return null;
        inOrder(pRoot,k);
        return ret;
    }
    private void inOrder(TreeNode pRoot,int k){
        if(pRoot==null||cnt>=k)return;
        inOrder(pRoot.left,k);
        cnt++;
        if(cnt==k){
            ret = pRoot;
        }
        inOrder(pRoot.right,k);
    }
}
