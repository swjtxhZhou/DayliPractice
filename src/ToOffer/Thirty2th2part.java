package ToOffer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Thirty2th2part {
    /**
     * 把二叉树打印成多行
     */
    //自己敲得
    public ArrayList<ArrayList<Integer>> print(TreeNode root){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        ret.add(root.val);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> ret = new ArrayList<>();
            int cnt = queue.size();
            while(cnt-- >0){
                TreeNode node = queue.poll();
                if(node==null){
                    continue;
                }
                ret.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if(ret.size()!=0){
                list.add(ret);
            }
        }
        return list;
    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                if (node == null)
                    continue;
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (list.size() != 0)
                ret.add(list);
        }
        return ret;
    }
}
