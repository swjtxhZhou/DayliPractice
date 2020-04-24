package ToOffer;

import ToOffer.Utils.ListNode;

public class Eightteen_practice {
    public ListNode deleteNode(ListNode head, ListNode targets){
        ListNode index;
        if(head==null||targets==null){return null;}
        //只有一个节点的情况
        if(head == targets){head =null;}
        //节点不在末尾
        if(targets.next!=null){
            targets.val=targets.next.val;
            targets.next = targets.next.next;
        }else{
            //末尾节点
            ListNode cur = head;
            while(cur.next!=targets){
                cur = cur.next;
            }
            cur.next=null;
        }
        return head;
    }
}
