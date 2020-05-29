package ToOffer.practice;


import java.util.ArrayList;

public class To8 {
    /**
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回 。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     * 我们先来回顾一下中序遍历的过程：先遍历树的左子树，再遍历根节点，最后再遍历右子树。所以最左节点是中序遍历的第一个节点。
     * 如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；
     *  否则，向上找第一个左链接指向的树包含该节点的祖先节点。
     */
    class TreeLinkNode {

        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null; // 指向父结点的指针

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    //找到颗树的根节点，然后根据中序保存在列表中，接着找到目标节点值得下一个节点的值
    static ArrayList<TreeLinkNode> list = new ArrayList<>();
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        //找根节点
        TreeLinkNode root = pNode;
        while(root.next!=null){
            root = root.next;
        }
        preOrder(root);
        for(int i=0;i<list.size();i++){
            if(list.get(i)==pNode){
                return i==list.size()-1?null:list.get(i+1);
            }
        }
        return null;
    }
    void preOrder(TreeLinkNode node){
        preOrder(node.left);
        list.add(node);
        preOrder(node.right);
    }

    //如果这个节点有右子树，那么它的下一个节点就会在它的左子树的最右节点
    //否则，向上找第一个节点该节点左树包含该目标节点的祖先节点
    public TreeLinkNode GetNext_2(TreeLinkNode pNode)
    {
        if(pNode.right!=null){
            pNode = pNode.right;
            while(pNode.left!=null){
                pNode = pNode.left;
            }
            return pNode;
        }else{
            //向上找一个节点，该节点的左子树是目标节点的祖先节点
            while(pNode.next!=null){
                TreeLinkNode parent = pNode.next;
                if(parent.left == pNode){
                    return parent;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }
}
