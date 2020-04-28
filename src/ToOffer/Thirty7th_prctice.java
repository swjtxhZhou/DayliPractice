package ToOffer;

public class Thirty7th_prctice {
    String str;
    public TreeNode Deserilize(){
        if(str.length()==0)return null;
        int index = str.indexOf(" ");
        String node = index==-1?str:str.substring(0,index);
        str = index==-1?"":str.substring(index+1);
        if(node.equals('#')){return null;}
        TreeNode t = new TreeNode(Integer.valueOf(node));
        t.left = Deserilize();
        t.right = Deserilize();
        return t;
    }
}
