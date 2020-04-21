package ToOffer;


import java.util.ArrayList;

import static Utils.StringUtils.*;

public class Eight {
    ArrayList<TreeLinkNode> list = new ArrayList<>();
    /**
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回 。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     */
    void traverse(TreeLinkNode root){//中序遍历
        if(root == null)return;
        traverse(root.left);
        list.add(root);
        traverse(root.right);
    }
    /**
     * 方法1,找到根节点，中序遍历树，存储到list当中，再从list中直接找已知节点的下一个节点
     */
    public TreeLinkNode method1(TreeLinkNode node){
        if(node == null)return null;
        TreeLinkNode root = node;
        while(root.parent != null){
            root = root.parent;
        }
        traverse(root);//中序遍历该树，并按中序顺序放在了list当中
        for(int i= 0;i<list.size();i++){
            if(node == list.get(i)){
                return i == list.size()-1?null:list.get(i+1);
            }
        }
        return null;
    }
    /**
     * 一个前序遍历为ABDEHICFG 中序遍历为DBHEIAFCG
     * 有右子树，下一结点是右子树中的最左结点，例如 B，下一结点是 H
     * 无右子树，且结点是该结点父结点的左子树，则下一结点是该结点的父结点，例如 H，下一结点是 E
     * 无右子树，且结点是该结点父结点的右子树，则我们一直沿着父结点追朔，直到找到某个结点是其父结点的左子树，如果存在这样的结点，那么这个结点的父结点就是我们要找的下一结点。例如 I，下一结点是 A；例如 G，并没有符合情况的结点，所以 G 没有下一结点
     */
    public TreeLinkNode  method2(TreeLinkNode node){
        if(node.right != null){//情况1
            TreeLinkNode temp = node.right;
            while(temp.left!=null){
                temp = temp.left;
            }
            return temp;
        }else if(node.parent !=null){
            if(node.parent.left == node){
                return node.parent;
            }else if(node.parent.right == node){
                TreeLinkNode parent = node.parent;
                /**
                 * 寻找最根部的节点
                 * 如果是g的情况，最后会返回A的父节点也就是null
                 * 如果是i的情况，最后会返回B的父节点也就是A
                 */
                while(parent.parent!=null && parent.parent.right == parent){
                    parent = parent.parent;
                }
                return parent.parent;
            }
        }
        return null;
    }
}
class TreeLinkNode{
    int value;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode parent;
    public TreeLinkNode(int val){value = val;}
    public String toString(){
        return Integer.toString(value);
    }
}
