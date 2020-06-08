package ToOffer.practice;

import ToOffer.Utils.ListNode;

public class To22 {
    /**
     * 输入一个链表，输出该链表中倒数第k个结点
     *两个指针指向头节点，让一个指针p1先走k步，这样这个指针到链表尾部的步数就是N-k（N是链表的长度），此时另一个指针p2和p1同时往后移动，直到p1走到链表尾部，那么p2就是走了N-k步，所以是倒数第k个节点
     * 这个题目的重点是怎么找到N-k的大小
     * ！！！做链表题要第一的方法就是想怎么利用双指针或者更多的指针
     *
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head==null||k==0){return null;}
        ListNode p1=head;
        ListNode p2=head;
        //让p1走K步，如果没有走到K步就到链表尾部了返回null
        for(int i=1;i<k;i++){
            if(p1.next==null)return null;
            p1 = p1.next;
        }
        //p1和p2同时往后面走，直到p1到达了链表尾部
        while(p1.next!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
