package ToOffer.practice;

import ToOffer.Utils.ListNode;

public class To25 {
    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     * 最后还是要返回头节点
     */
    //迭代
    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1==null)return list2;
        if(list2==null)return list1;
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        while(list1!=null&&list2!=null){
            if(list1.val>list2.val){
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }else{
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            }
        }
        if(list1!=null){
            cur.next = list1;
        }
        if(list2!=null){
            cur.next = list2;
        }
        return head.next;

    }
}
