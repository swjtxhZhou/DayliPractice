package ToOffer.practice;

import ToOffer.Utils.ListNode;

public class To18 {
    /**
     * 在O（1）时间删除节点
     * 如果不是尾节点，可以令要删除节点的上一个节点的next指针指向要删除节点的下一个节点，时间复杂度为O（1）
     * 如果是尾节点就需要遍历到链表尾部，然后令该节点的上一个节点的next指针为null，时间复杂度为O（n），n是链表的长度。
     * 综上，如果进行 N 次操作，那么大约需要操作节点的次数为 N-1+N=2N-1，其中 N-1 表示 N-1 个不是尾节点的每个节点以 O(1) 的时间复杂度操作节点的总次数，N 表示 1 个尾节点以 O(N) 的时间复杂度操作节点的总次数。(2N-1)/N ~ 2，因此该算法的平均时间复杂度为 O(1)。
     * ！！！判断该节点是否是尾节点
     */
    public ListNode deleteListNode(ListNode head,ListNode node){
        if(head==null||node==null)return head;
        //判断节点是不是尾节点
        if(node.next==null){
            return deleteTailNode(head,node);
        }
        //不是尾节点，不去找上一个节点，将下一个节点的值赋给要删除的节点，让当前节点指向下下个节点

        node.val = node.next.val;
        node.next = node.next.next;
        return head;
    }
    public ListNode deleteTailNode(ListNode head,ListNode node){
        ListNode temp=head;
        while(temp.next!=node){
            temp = temp.next;
        }
        temp.next=null;
        return head;
    }
}
