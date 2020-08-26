package 面前练习.美团点评8_22面前练习;

import ToOffer.Utils.ListNode;

public class AboutListNode {
    /**
     * 创建链表，头插法、尾插法
     */
    public static void addFirst(ListNode head,int data){
        ListNode node = new ListNode(data);
        //如果头节点为空，则将当前节点设为头节点
        if(head==null){
            head = node;
        }else{
            node.next=head.next;
            head.next = node;
        }
    }
    public static void addLast(ListNode head,int data){
        ListNode node = new ListNode(data);
        //如果头节点为空，则将当前节点设为头节点
        ListNode p = head;
        if(head==null){
            head = node;
        }else{
            //找到最后一个节点，把要插入的节点放到最后一个节点后面
            while(p.next!=null){
                p = p.next;
            }
            p.next = node;
        }
    }
    /**
     * 反转链表，要求用递归
     * @param head
     * @return
     */
    public static ListNode reverseListNode_digui(ListNode head){
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverseListNode_digui(next);
        next.next = head;
        //返回的是最后一个节点
        return newHead;
    }
    public static ListNode reverseListNode_diedai(ListNode head){
        if(head==null||head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(-1);
        ListNode cur = head;
        ListNode next;
        while(cur!=null){
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        return newHead.next;
    }

    /**
     * 怎么判断链表有环
     * 使用快慢指针，一个指针走一步，一个指针走两步
     */
    public static boolean judgeLoop(ListNode head){
        if(head==null){
            return true;
        }
        ListNode quick = head;
        ListNode slow = head;
        while(quick!=null&&quick.next!=null){
            //如果不存在环，那么快节点会先走完，所以用快指针来做循环判断
            //如果存在环，那么不会除了两个指针相遇，否则不会跳出循环
            slow = slow.next;
            quick = quick.next.next;
            if(slow==quick){
                return true;
            }
        }
        return false;
    }
    /**
     * 找到链表的环的入口
     * 使用一个快指针和一个慢指针，一个走两步一个走一步，当两个指针第一次相遇了，快指针从相遇的点一次走一步，慢指针从头节点一次走一步，再次相遇就是环的入口
     */
    public static ListNode findBeginOfLoop(ListNode head){
        ListNode slow = head.next;
        ListNode quick = head.next.next;
        while(slow!=quick){
            slow = slow.next;
            quick = quick.next.next;
        }
        //找到了相遇的点
        slow = head;
        while(slow!=quick){
            slow = slow.next;
            quick = quick.next;
        }
        return slow;
    }
    /**
     * 如何找到倒数第K个节点（快慢指针）
     * 先使用一个指针走K次，然后另一个指针从头节点出发，两个指针同时走，知道第一个指针走到了尾部
     */
    public static ListNode fingKthNode(ListNode head,int k){
        ListNode first = head;
        ListNode second = head;
        for(int i=0;i<k;i++){
            first = first.next;
        }
        while(first!=null){
            first = first.next;
            second =second.next;
        }
        return second;
    }


}
