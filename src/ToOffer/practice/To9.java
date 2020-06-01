package ToOffer.practice;

import java.util.Stack;

public class To9 {
    /**
     * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
     */
    Stack<Integer> stack1 = new Stack<Integer>();//充当in栈
    Stack<Integer> stack2 = new Stack<Integer>();//充当out栈
    //不需要检查
    public void push(int node) {
        stack1.add(node);
    }
    //为了保证顺序的正确，要在每次stack2出完了之后才能将stack1的元素往里面放。
    public int pop() {
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
            return stack2.pop();
        }else{
            return stack2.pop();
        }
    }
}
