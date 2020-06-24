package ToOffer.practice;

public class To33 {
    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     * 递归思想
     * 后序遍历数组的的最后一位一定是二叉搜索树的根节点
     * 找根节点的左子节点，从数组的开头开始遍历直到遇到元素不大于根节点元素，这一段的元素子集就是左子树的所有元素。这些元素都是小于根节点的。那么剩余一段的元素子集就是右子树的所有元素，判断这些元素是否都是大于根节点的
     * 然后将左右子树的元素子集分别继续递归
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0)return false;
        return verify(sequence,0,sequence.length-1);
    }

    private boolean verify(int[] sequence,int first,int last){
        if(last-first<=1)return true;
        int root = sequence[last];//根节点
        int index = first;
        while(index<last&&sequence[index]<root){
            index++;
        }
        for(int i=index;i<last;i++){
            if(sequence[i]<root){
                return false;
            }
        }
        return verify(sequence,0,index-1)&&verify(sequence,index,last-1);
    }
}
