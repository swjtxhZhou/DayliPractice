package ToOffer.practice;

import ToOffer.Utils.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class To6 {
    /**
     * 从尾到头反过来打印出每个结点的值。
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     */
    //头插法
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode phead = new ListNode(-1);
        while(listNode != null){
            ListNode next = listNode.next;
            listNode.next = phead.next;
            phead.next = listNode;
            listNode = next;
        }
        ArrayList<Integer> res = new ArrayList<>();
        ListNode index=phead.next;
        while(index!=null){
            res.add(index.val);
            index = index.next;
        }
        return res;
    }
    //使用栈，会用到多余的空间
    public ArrayList<Integer> printListFromTailToHead_Stack(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while(listNode!=null){
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
}
