package ToOffer;

import thinkingInJava.August18th.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Six {
    /**
     * 这个是递归的方案，缺点很明显很占用大量的内存，链表太长运行速度会很慢，很可能会溢出，
     * addAll的参数可以传入Collection，该方案通过ret.addAll(printListFromTailToFirst(node.next));会不断递归到最后一个节点，然后返回一个list，里面是最后一个节点的值，这样继续往回递归，就能实现逆序
     * @param node
     * @return
     */
    public ArrayList<Integer> printListFromTailToFirst(Node node){
        ArrayList<Integer> ret = new ArrayList<>();
        if(node != null){
            ret.addAll(printListFromTailToFirst(node.next));
            ret.add(node.value);
        }
        return ret;
    }

    /**
     * 头插法：头插法顾名思义是将节点插入到头部：在遍历原始链表时，将当前节点插入新链表的头部，使其成为第一个节点。 链表的操作需要维护后继关系，例如在某个节点 node1 之后插入一个节点 node2，我们可以通过修改后继关系来实现：
     * 这个方法会破坏链表的结构
     */
    public ArrayList<Integer> printListFromTailToFirst2(Node node){
        ArrayList<Integer> ret = new ArrayList<>();
        Node head = new Node(-1);
        while(node!=null){
            /**
             * 先存储目标链表的第二个节点，让目标链表的第一个节点next指向新建有头链表的next，再让有头链表的next指向原始链表的第一个节点，将存储的第二个节点作为目标链表的新的第一个节点
             *
             */
            Node memo = node.next;//存储下一个节点
            node.next = head.next;//切断原始链表的第一个节点,拼接到新节点的头指针后面
            head.next = node;
            node = memo;
        }
        /**
         * 把新的链表挨个访问，加入到list中（除了头结点）
         */
        while(head.next !=null){
            ret.add(head.next.value);
            head.next = head.next.next;//删去这个节点
        }
        return ret;

    }

    /**
     * 使用栈的先进后出的性质
     * @param node
     * @return
     */
    public ArrayList<Integer> printListFromTailToFirst3(Node node){
        /**
         * 把节点挨个放到栈里面
         */
        Stack<Node> stack = new Stack<>();
        while(node !=null){
            stack.push(node);
            node = node.next;
        }
        /**
         * 从栈里面挨个取出来
         */
        ArrayList<Integer> list = new ArrayList<>();
        while(!stack.empty()){
           list.add(stack.pop().value);
        }
        return list;
    }
    public static void main(String[] args){
        Node node= new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(6);
        Node node3 = new Node(9);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        Six six =new Six();
//        ArrayList<Integer> reverseList = six.printListFromTailToFirst(node);
//        ArrayList<Integer> reverseList = six.printListFromTailToFirst2(node);
        ArrayList<Integer> reverseList = six.printListFromTailToFirst3(node);
        System.out.println(reverseList);

    }
}
class Node{
    Node last;
    Node next;
    int value;
    public Node(int val){value = val;}
}
