package ToOffer.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class To32_1 {
    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * 这个就很像图的广度优先遍历，所以第一个想的就是用一个队列来存一个节点的左右节点
     * 一开始会想使用遍历的方法，有迭代或者递归,这里不适合用这种方式来遍历树，找不到方法的出口在哪里
     * 使用队列来判断是否结束方法，并返回
     */


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null)return list;
        queue.add(root);
        while(!queue.isEmpty()) {
//            int cnt = queue.size();
//            while (cnt-- > 0) {
                TreeNode t = queue.poll();
//                if(t==null){
//                    continue;
//                }
                list.add(t.val);
                if(t.left!=null)queue.add(t.left);
                if(t.right!=null)queue.add(t.right);
            }
        return list;

    }
}
