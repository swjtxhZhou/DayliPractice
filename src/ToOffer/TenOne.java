package ToOffer;

public class TenOne {
    /**
     * 请问用n个2 * 1的小矩形无重叠地覆盖一个2 * n的大矩形，总共有多少种方法？
     */
    //递归实现
    public int RectRocover(int n){
// 被覆盖的目标矩形的形状： 2*n
        // 每次新增加的一列，（1）如果竖着放对应的情况与 target为 n-1 时相同；
        // （2如果横着放，对应的情况与 target 为 n-2 时相同
        if(n<2){return n;}
        else{
            return RectRocover(n-1)+RectRocover(n-2);
        }
    }
    //减少了时间复杂度
    public int RectRocover2(int n){
        if(n<2)return n;
        int result = 0;
        int pre1 = 2;//横放时
        int pre2 = 1;//竖放时
        for(int i=3;i<=n;i++){
            result = pre1+pre2;
            pre1 = result;
            pre2 = pre1;
        }
        return result;
    }
    public static void main(String[] args){
        TenOne tenOne = new TenOne();
        System.out.println(tenOne.RectRocover2(3));
    }
}
