package ToOffer.practice;

import java.util.ArrayList;
import java.util.List;

public class To34 {
    /**
     * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     *
     * 这里需要全局变量来保存可以满足目标的路劲，用局部变量没有办法收集所有的路劲
     * 还有就是局部变量加入到全局变量那里要使用新的对象包含原来的list，不然会出错
     *
     * 主要是回溯的思想，每次回溯的时候要注意清理掉当次操作的状态才返回上一层
     */
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null)return lists;
        FindPath(root,target,new ArrayList<>());
        return lists;
    }

    private void FindPath(TreeNode node, int target, ArrayList<Integer> list){
        //递归最底层终止条件
        if(node==null)return;
        list.add(node.val);
        //还没有到达叶子节点
        target-=node.val;
        //到达叶子节点，满足了目标值
        if(node.left==null&&node.right==null&&target==0){
            lists.add(new ArrayList<>(list));
        }else {
            //继续往下面找
            FindPath(node.left, target, list);
            FindPath(node.right, target, list);
            //从上面出来了，要把当前元素移除，继续往上个栈回溯
        }
      //  target+=node.val;//target不是引用所以不用在加上该节点的值来清楚操作痕迹
        list.remove(list.size()-1);
    }
}
