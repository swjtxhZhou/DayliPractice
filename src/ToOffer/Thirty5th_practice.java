package ToOffer;

import ToOffer.Utils.RandomListNode;

public class Thirty5th_practice {
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null)return null;
        //复制
        RandomListNode cur = pHead;
        while(cur!=null){
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        //复制Random指针
        cur = pHead;
        while(cur!=null){
            RandomListNode clone = cur.next;
            if(cur.random!=null){
                clone.random = cur.random;
            }
            cur = clone.next;
        }
        //分离
        cur = pHead;
        RandomListNode clonePHead = cur.next;
        while(cur != null){
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return clonePHead;
    }

}
