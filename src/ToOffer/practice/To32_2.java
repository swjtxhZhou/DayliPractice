package ToOffer.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class To32_2 {
    /**
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     * 这里仍然是使用队列，但是要判断一层的结束是在哪里，
     * 这里需要一个额外的数字量来保存一层的节点数量
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(pRoot==null)return lists;
        queue.add(pRoot);
        while(!queue.isEmpty()){
            int cnt = queue.size();
            ArrayList<Integer> list =new ArrayList<>();
            while(cnt-- >0){
                TreeNode t = queue.poll();
                if(t==null)continue;
                list.add(t.val);
                if(t.left!=null)queue.add(t.left);
                if(t.right!=null)queue.add(t.right);
            }
            lists.add(list);
        }
        return lists;
    }
}
