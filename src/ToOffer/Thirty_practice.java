package ToOffer;

import java.util.Stack;

public class Thirty_practice {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();//minStack会把最小值一直放在栈顶

    public void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));//这里维持了原始栈和最小值栈中的元素个数

    }

    public void pop() {//不用去判断两者栈顶的元素是否相同，如果最小值不在原始栈顶，最小值栈前面的元素都会是最小值
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
