package thinkingInJava.August18th;

public class StackTest {
    public static void main(String[] args){
        Stack<String> stack = new Stack<String>();
        for(String s:"thinkingInJava.A B C D E".split(" ")){
            stack.push(s);
            while(!stack.empty()){
                System.out.println(stack.pop()+" ");
            }
        }
    }
}
