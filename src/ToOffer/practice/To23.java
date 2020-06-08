package ToOffer.practice;

import ToOffer.Utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class To23 {
    /**
     * 链表中环的入口结点
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     *
     */
    //使用一个set来保存节点，当遇到重复的节点就是环的入口。
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead==null||pHead.next==null)return null;
        Set<ListNode> set = new HashSet<>();
        while(true){
            if(!set.contains(pHead)){
                set.add(pHead);
            }else{
                return pHead;
            }
            pHead = pHead.next;
        }
    }
    //不使用额外的内存空间，用快慢指针来解决
    //具体就不用公式推了，具体步骤就是让快指针一次走两步，慢指针一次走一步，第一次相遇后。让快指针从相遇地点一次走一步，慢指针从头节点开始一次走一步，再次相遇就是环的入口
    public ListNode EntryNodeOfLoop_noOtherSpace(ListNode pHead) {
        if(pHead==null||pHead.next==null)return null;
        Set<ListNode> set = new HashSet<>();
        ListNode fast = pHead;
        ListNode slow = pHead;
        do{
            fast = fast.next.next;
            slow = slow.next;
        }while(fast!=slow);
        //此时已经相遇了
        slow = pHead;
        while(fast!=slow){
            fast=fast.next;
            slow = slow.next;
        }
        return slow;
    }


}
