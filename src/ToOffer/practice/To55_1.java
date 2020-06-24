package ToOffer.practice;

import java.util.ArrayList;
import java.util.Collections;

public class To55_1 {
    /**
     * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     * 考察点：树
     * 首先需要肯定的是一定要遍历完整颗树才行
     * 思路：用一个全局变量来保存到达叶子节点的路劲
     * 利用树的前序遍历，每经过一个节点就增加路径值，直到达到叶子节点把路径值加入到list中。递归返回的时候要减去将路径值减一
     * 然后选取最长路径返回
     */
    private ArrayList<Integer> list = new ArrayList<>();
    public int TreeDepth(TreeNode root) {
        if(root==null)return 0;
        inOrder(root);
        Collections.sort(list);//默认应该是升序就是从小到大
        return list.get(list.size()-1);
    }
    int cnt=0;
    private void inOrder(TreeNode node){
        if(node==null){
            list.add(cnt);
            return;
        }
        cnt++;
        inOrder(node.left);
        inOrder(node.right);
        cnt--;
    }
}
