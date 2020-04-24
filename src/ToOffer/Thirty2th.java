package ToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Thirty2th {
    /**
     *从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     *
     * 例如，以下二叉树层次遍历的结果为：1,2,3,4,5,6,7
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();//没取出打印一个节点就检查是否有叶子节点，如果有就从左到右依次存放在队列末尾
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt-- > 0) {//这一步不太清楚是干嘛
                TreeNode t = queue.poll();
                if (t == null)
                    continue;
                ret.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
        }
        return ret;
    }


}
