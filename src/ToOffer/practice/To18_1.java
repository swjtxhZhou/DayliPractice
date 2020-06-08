package ToOffer.practice;

import ToOffer.Utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class To18_1 {
    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     * 方法一：使用set，暴力解法，如果能够知道重复的值是什么，然后再遍历一次单链表，删除重复的值就行
     */
    //这个被判断超过时间
    public ListNode deleteDuplication_tooLong(ListNode pHead) {
        if(pHead==null)return null;
        //找相同的节点,把节点的val值放入set中
        Set<Integer> set = new HashSet<>();
        ListNode next = pHead.next;
        ListNode temp = pHead;
        while(next!=null){
            if(temp.val.equals(next.val)){
                set.add(next.val);
            }
            temp= next;
            next = next.next;
        }
        //判断头节点会不会被删除
        while(pHead!=null && set.contains(pHead.val)){
            pHead = pHead.next;
        }
        if(pHead==null)return null;
        //头节点肯定不是重复的节点了
        temp = pHead;
        next = pHead.next;
        while(next!=null){
            if(set.contains(next.val)){
                temp.next=next.next;
                next.next=null;
            }else{
                temp = next;
                next = next.next;
            }
        }
        return pHead;
    }

    //一边遍历一边删除。
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead==null)return null;
        //用一个新的头节点指向原来的头节点
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = pHead;
        while(cur!=null){
            if(cur.next!=null&&cur.val==cur.next.val){
                while(cur.next!=null && cur.val==cur.next.val){
                    cur = cur.next;
                }
                //结束循环后，cur仍然执行最后一个重复的元素
                //删除的过程
                cur = cur.next;
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }
    //一边遍历一边删除的递归方法
    public ListNode deleteDuplication_diGui(ListNode pHead){
        if(pHead==null||pHead.next==null){
            return pHead;
        }
        //如果相同就递归跳过
        ListNode next = pHead.next;
        if(pHead.val==next.val){
            while(next!=null&&next.val==pHead.val) {
                next = next.next;
            }
            //最后出来的next一种是不重复元素（重复元素的后一位）一种就是null（走到了链表的尾部）
            return deleteDuplication_diGui(next);
        }else{
            //不相同，连到上一个节点的next指针
            pHead.next = deleteDuplication_diGui(next);
            return pHead;
        }
    }
}
