package ToOffer;

public class Thirty7th {
    /**
     * 请实现两个函数，分别用来序列化和反序列化二叉树。
     */
    private String deserializeStr;

    /**
     * 前序遍历整棵树，如果遇见节点为空用#表示
     * @param root
     * @return
     */
    public String Serialize(TreeNode root) {
        if (root == null)
            return "#";
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    /**
     * 反序列化，
     * @param str
     * @return
     */
    public TreeNode Deserialize(String str) {
        deserializeStr = str;
        return Deserialize();
    }

    private TreeNode Deserialize() {
        if (deserializeStr.length() == 0)
            return null;
        int index = deserializeStr.indexOf(" ");//索引空格的位置
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);//字符串中还有空格，将第一个字符取出来
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);//将取出来的字符从目标字符中移除
        if (node.equals("#"))
            return null;
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = Deserialize();
        t.right = Deserialize();
        return t;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1),
                node1 = new TreeNode(2),
                node2 = new TreeNode(3),
                node3 = new TreeNode(4),
                node4 = new TreeNode(5);
        root.left = node1;root.right = node2;
        node1.right = node3;node2.left = node4;
        Thirty7th thirty7th = new Thirty7th();
        String serializeTree = thirty7th.Serialize(root);
        System.out.println(serializeTree);
    }
}
