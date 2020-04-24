package ToOffer;

import ToOffer.Utils.ListNode;

public class Twenty4th_practice {
    /**
     *反转链表
     */
    //头插法
    public ListNode ReverseList(ListNode head){
        if(head == null||head.next==null)return head;
        ListNode newList = new ListNode(-1);
        while(head != null){
            ListNode next = head.next;
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;
    }
    public static void main(String[] args){
        Twenty4th_practice twenty4th_practice = new Twenty4th_practice();
        ListNode index ;
        ListNode pHead= new ListNode(1);
//        ListNode pHead = new ListNode(1),
//                node1 = new ListNode(2),
//                node2 = new ListNode(3),
//                node3 = new ListNode(4);
//        pHead.next = node1;
//        node1.next = node2;
//        node2.next = node3;
        //简便创建链表
        index = pHead;
        for(int i=2;i<5;i++){
            index.next = new ListNode(i);
            index = index.next;
        }
        ListNode resultHead = twenty4th_practice.ReverseList(pHead);
        index = resultHead;
        while(index!=null){
            System.out.println(index.val);
            index=index.next;
        }
    }
}
