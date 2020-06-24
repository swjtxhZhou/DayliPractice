package ToOffer.practice;

import ToOffer.Utils.ListNode;

public class To62 {
    /**
     * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
     * 考察点：循环链表
     * 思路：
     * 1、每次固定是走m步的长度
     * 2、每次走完环的长度会减少，怎么维持原来的位置？？
     * 3、将n创建一个环形链表来保存1-n的原来位置数量，每走完一圈就删除掉一个链表
     * 4、删除当前节点需要一个辅助节点，该辅助节点一直处于当前节点的前一位
     * 5、创建环形链表也需要辅助节点。辅助节点记录上一次新添加进来的节点
     * 约瑟夫环
     */
    //创建一个大小为n的循环链表
    ListNode first =null;
    ListNode pre =null;
    private void addBoy(int n){
        ListNode curNode = null;//辅助节点用于创建环
        for(int i=0;i<n;i++){
            ListNode boy = new ListNode(i);
            if(i==0){
                first=boy;
                first.next=first;
                curNode=first;
            }else{
                curNode.next=boy;
                boy.next=first;
                curNode=boy;
            }
        }
        pre = curNode;//first节点之前的节点
    }
    //计算最后出来的小孩的编号
//    private int count(int n,int m){
//        addBoy(n);
//        ListNode target = first;
//        while(target.next==target){
//            for(int i=1;i<m;i++){
//                target = target.next;
//            }
//            target.next = target.next.next;
//        }
//        return target.val;
//    }
    public int LastRemaining_Solution(int n, int m) {
        addBoy(n);
        ListNode target = first;
        ListNode helper = pre;
//        System.out.println(first+"\n"+pre);
        while(helper!=target){
            for(int i=1;i<m;i++){
                target = target.next;
                helper = helper.next;
            }
            System.out.println(target);
            target = target.next;
            helper.next = target;
        }
        return target.val;
    }

    //递归解法
    public int LastRemaining_Solution_digui(int n, int m) {
        if(m<=0)return -1;
        if(n==0)return 0;//最后一次选出的孩子的编号映射的值
        return (LastRemaining_Solution_digui(n-1,m)+m)%n;
    }
    public static void main(String[] args){
        To62 to62 = new To62();
        int num = to62.LastRemaining_Solution(5,3);
    }
}
