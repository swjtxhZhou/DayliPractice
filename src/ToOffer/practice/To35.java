package ToOffer.practice;

import ToOffer.Utils.RandomListNode;

public class To35 {
    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     *
     * 一开始没有什么思路，这种问题应该从链表本身的指针上面做一些操作。
     *
     * 整个过程分为三部
     * 在每一个原始节点的后面插入复制节点
     * 对复制节点的random链接进行复制
     * 把原节点与复制节点进行拆分
     */
    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null)return null;
        //在每个原节点的后面插入一个克隆的新节点
        RandomListNode cur = pHead;
        while(cur!=null){
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        //为新节点建立Random链接
        cur = pHead;
        while(cur!=null) {
            RandomListNode clone = cur.next;
            if (cur.random != null) {
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }
        //将新旧链表拆开，使每一个链表指向它的下下个节点
        cur = pHead;
        RandomListNode clonePHead = pHead.next;
        while(cur.next!=null){
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return clonePHead;
    }
}
