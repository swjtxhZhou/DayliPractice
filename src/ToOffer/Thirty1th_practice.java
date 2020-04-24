package ToOffer;

import java.util.Stack;

public class Thirty1th_practice {
    public boolean isPopOrder(int[] pushSequence,int[] popSequence){
        int n = pushSequence.length;
        Stack<Integer> stack = new Stack<>();
        for(int popIndex=0,pushIndex=0;pushIndex<n;pushIndex++){
            stack.push(pushSequence[pushIndex]);
            //如果栈顶元素等于数组B的第一个元素，就将其弹出，数组B的元素也往后指一位
            while(!stack.isEmpty()&&popIndex<n&&popSequence[popIndex]==stack.peek()){
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();//如果还有元素说明不满足条件
    }
}
