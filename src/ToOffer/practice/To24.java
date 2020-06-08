package ToOffer.practice;

import ToOffer.Utils.ListNode;
import thinkingInJava.August18th.Stack;

public class To24 {
    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     */
    //头插法，这个会破坏原始链表的结构
    public ListNode ReverseList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode pHead = new ListNode(Integer.MIN_VALUE);
        while(head!=null){
            ListNode next = head.next;
            head.next = pHead.next;
            pHead.next = head;
            head = next;
        }
        return pHead.next;
    }
    //使用一个栈，不会破坏原始链表的结构，遍历链表依次把他放在一个栈里面
    //这个方法会超时。
    public ListNode ReverseList_Stack(ListNode head){
        if(head==null||head.next==null)return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while(temp!=null){
            stack.push(temp);
            temp = temp.next;
        }
        temp = stack.pop();
        ListNode res = temp;
        while(!stack.empty()){
            temp.next = stack.pop();
            temp = temp.next;
        }
        return res;
    }
}
