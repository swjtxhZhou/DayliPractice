package ToOffer;

import ToOffer.Utils.ListNode;

public class Twenty2th_practice {
    public ListNode findKthToTail(ListNode head, int k){
        if(head==null){return null;}
        int i=0;
        ListNode p1=head;
        ListNode p2;
        while(i<k){//p1移动到n-k的位置上，n是链表的长度（未知）
            p1=p1.next;
            i++;
        }
        //p2开始移动直到p1到达链表末尾
        p2=head;
        while(p1.next==null){
            p2=p2.next;
            p1=p1.next;
        }
        return p2;
    }
}
