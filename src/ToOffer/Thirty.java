package ToOffer;

import java.util.Stack;

public class Thirty {
    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的 min 函数。
     */
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();//minStack会把最小值一直放在栈顶

    public void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {//这里感觉有问题，如果两者的栈顶元素不一致，弹出去后，minStack的栈顶就不是加入栈中的最小值了
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
