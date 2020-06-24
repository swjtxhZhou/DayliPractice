package ToOffer.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class To32_3 {
    /**
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     *
     * 一开始想的是利用栈来做，但是打印顺序有问题
     * 还是使用队列，加入一个逆序打印的标志，需要逆序的时候使用Collections工具类使list逆序
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(pRoot==null)return lists;
        queue.add(pRoot);
        boolean reverse=false;
        while(!queue.isEmpty()){
            int cnt = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while(cnt-- >0){
                TreeNode t = queue.poll();
                if(t == null)continue;
                list.add(t.val);
                if(t.left!=null)queue.add(t.left);
                if(t.right!=null)queue.add(t.right);
            }
            if(reverse) Collections.reverse(list);
            lists.add(list);
            reverse=!reverse;
        }
        return lists;
    }
}
