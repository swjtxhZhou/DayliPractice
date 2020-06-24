package ToOffer.practice;

import thinkingInJava.August18th.Stack;

public class To30_notSimilar {
    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
     * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
     * 一开始想的方法是定义一个变量，存储最小值，但是有一个问题就是弹出元素后就不知道最小值是不是弹出去了，此时保存的min就不一定是最小值
     * ！！！使用两个stack
     * 如果新加入的元素没有minStack的最上面个的元素小，那么会压入一个相同的最小元素；否则会压入新加入的元素；
     * 这样每次弹出元素都能保证是当前的最小元素
     */
    Stack<Integer> numStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
//    int min = Integer.MAX_VALUE;
    public void push(int node) {
        numStack.push(node);
        minStack.push(minStack.empty()?node:Math.min(node,minStack.peek()));
//        if(node<min)min = node;
    }

    public void pop() {
        numStack.pop();
        minStack.pop();
    }

    public int top() {
        return numStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
