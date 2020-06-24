package ToOffer.practice;

import ToOffer.Utils.ListNode;

public class To52 {
    /**
     * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
     *考察点：链表，特点不知道长度
     * 两个指针分别从两个头指针出发，当到尾节点的时候就从另一个头指针继续走。直到两个节点相遇就是公共节点
     * 第一条链表长度为x+n,第二条链表长度为y+n,两个指针走过的长度都为x+y+n
     * 有一个小细节没有注意就是判断是否到了链表的尾部，如果没有就沿着链表走下一个。如果到了就重新从另一个链表头部走。这是一个if-else过程。二选一的
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null)return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1!=p2){
            if(p1==null){
                p1 = pHead2;
            }else{
                p1=p1.next;
            }
            if(p2==null){
                p2 = pHead1;
            }else{
                p2=p2.next;
            }
        }
        return p1;
    }
}
