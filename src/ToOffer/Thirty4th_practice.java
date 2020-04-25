package ToOffer;

import java.util.ArrayList;

public class Thirty4th_practice {
    /**
     * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     *      * 深度优先搜索
     */
    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int targetNum){
        BackTracking(root,targetNum,new ArrayList<>());
        return ret;
    }
    void BackTracking(TreeNode node,int targetNum,ArrayList<Integer> path){
        if(node == null){return;}
        targetNum -=node.val;
        path.add(node.val);
        if(node.right==null&&node.left==null&&targetNum==0){
            ret.add(new ArrayList<>(path));//这里不用add(path)是因为这样ret只会存储path的地址而不是其中的值
        }
        BackTracking(node.left,targetNum,path);
        BackTracking(node.left,targetNum,path);
        path.remove(path.size()-1);
    }
}
