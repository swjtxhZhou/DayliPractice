package ToOffer;

import ToOffer.Utils.ListNode;
import thinkingInJava.August18th.Stack;

public class Twenty4th {
    /**
     * 反转链表
     *
     */
    //利用栈
    public ListNode ReverseList(ListNode pHead){
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode newPHead = new ListNode();
        ListNode index;
        //把原始链表依次压入到栈当中
        Stack<Integer> stack = new Stack<>();
        index = pHead;
        while(index!=null){
            Integer value = index.val;
            stack.push(value);
            index = index.next;
        }
        //创造新的链表
        index = newPHead;
        index.val = stack.pop();
        while(!stack.empty()){
            index.next = new ListNode(stack.pop());
            index = index.next;
        }
        return newPHead;

    }
    public static void main(String[] args){
        Twenty4th twenty4th = new Twenty4th();
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
        ListNode resultHead = twenty4th.ReverseList1(pHead);
        index = resultHead;
        while(index!=null){
            System.out.println(index.val);
            index=index.next;
        }
    }
    //递归
    public ListNode ReverseList1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = ReverseList1(next);
        next.next = head;
        return newHead;
    }

    //头插法(旋转指针)
    public ListNode ReverseList2(ListNode head) {
        ListNode newList = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;
    }
}
