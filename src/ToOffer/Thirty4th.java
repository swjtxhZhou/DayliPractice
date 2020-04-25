package ToOffer;

import java.util.ArrayList;

public class Thirty4th {
    /**
     * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * 深度优先搜索
     */
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        backtracking(root, target, new ArrayList<>());
        return ret;
    }

    private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null)//当前节点为空，返回
            return;
        path.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {//binggo
            ret.add(new ArrayList<>(path));
        } else {//继续往下走
            backtracking(node.left, target, path);
            backtracking(node.right, target, path);
        }
        path.remove(path.size() - 1);//已经将这个节点的左右子树走完了，可能会存在可以走通的路线，返回上一层的时候要移去这个节点，继续去寻找其他的出路，如果不移去这个节点该条Path中存储的值就会是有问题的。
    }

    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        ArrayList<Integer> path = new ArrayList<>();
        this.find(root, target, result, path);
        return result;
    }
    private void find(TreeNode root, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {
        // 0，当节点为空，return
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;

        // 1，当目标值小于0，return
        if(target < 0){
            return;
        }
        // 2，当目标值为0 并且 节点下无其他节点, 保存并返回
        if(target == 0 && root.left == null && root.right == null){
            result.add(path);
            return;
        }
        // 继续遍历左右节点
        // 这里new path是因为左右都会在下次递归path.add(root.val);
        this.find(root.left, target, result, new ArrayList<>(path));
        this.find(root.right, target, result, new ArrayList<>(path));
    }


    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath3(TreeNode root,int target) {
        if(root == null)return result;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            result.add(new ArrayList<Integer>(list));
//因为在每一次的递归中，我们使用的是相同的result引用，所以其实左右子树递归得到的结果我们不需要关心，
//可以简写为FindPath(root.left, target)；FindPath(root.right, target)；
//但是为了大家能够看清楚递归的真相，此处我还是把递归的形式给大家展现了出来。
        FindPath3(root.left, target);
        FindPath3(root.right, target);
        list.remove(list.size()-1);
        return result;
    }
}
