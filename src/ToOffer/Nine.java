package ToOffer;

import java.util.Stack;

public class Nine {
    /**
     * 用两个栈实现队列
     * 队列的性质是先进先出，栈的性质是先进后出
     * in 栈用来处理入栈（push）操作，out 栈用来处理出栈（pop）操作。一个元素进入 in 栈之后，出栈的顺序被反转。当元素要出栈时，需要先进入 out 栈，此时元素出栈顺序再一次被反转，因此出栈顺序就和最开始入栈顺序是相同的，先进入的元素先退出，这就是队列的顺序
     */
    class MyQueue{
        Stack<Integer> in = new Stack<>(),
                out = new Stack<>();
        public void push(int val){
            in.push(val);
        }
        public int pop()throws  Exception{
            if(out.isEmpty()){
                while(!in.empty()){
                    out.push(in.pop());
                }
            }
            if(out.isEmpty()){
                throw new Exception("queue is empty");
            }
            return out.pop();
        }
    }

}
