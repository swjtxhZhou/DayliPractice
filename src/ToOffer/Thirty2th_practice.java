package ToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Thirty2th_practice {
    public ArrayList<Integer> printTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int cnt = queue.size();//cnt是每次队列中元素的个数，
            while (cnt-- >0) {//当上一个状态的队列中的元素全部过一遍再退出，相当于一层一层的扫描
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                ret.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return ret;
    }
}
