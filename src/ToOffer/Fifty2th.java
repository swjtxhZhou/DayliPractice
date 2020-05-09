package ToOffer;

import ToOffer.Utils.ListNode;

public class Fifty2th {
    /**
     *两个链表的第一个公共结点
     * 设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
     *
     * 当访问链表 A 的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；同样地，当访问链表 B 的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
     */
    public ListNode FindFirstCommonNode(ListNode pHead1,ListNode pHead2){
        ListNode index1 = pHead1,index2 = pHead2;
        while(index1!=index2){
            index1 = index1==null?pHead2:index1.next;
            index2 = index2==null?pHead1:index2.next;
        }
        return index1;
    }
}
