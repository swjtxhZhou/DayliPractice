package ToOffer.practice;

import java.util.LinkedList;
import java.util.Queue;

public class To50 {
    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
     * 考察点：字符串
     * 想法
     * 1、肯定要把字符串遍历完才知道结果
     * 2、用长度为256的字节数组来表示256个字符
     * 3、用一个队列来判断是否是第一次出现
     * 4、这里是返回它的位置
     */
    public int FirstNotRepeatingChar(String str) {
        if(str==null||str.length()==0){return -1;}
        byte[] ch = new byte[256];
        char[] chars = str.toCharArray();
        Queue<Character> queue = new LinkedList<>();
        for(int i=0;i<str.length();i++){
            if(ch[chars[i]]==0){
                ch[chars[i]]=1;
            }else if(ch[chars[i]]==1){
                ch[chars[i]]=10;
            }
            queue.add(chars[i]);
            while(!queue.isEmpty()&&ch[queue.peek()]==10){
                queue.poll();
            }
        }
        return queue.peek()!=null?str.indexOf(queue.peek()):-1;
    }
    public static void main(String[] args){
        To50 to50 = new To50();
        int num = to50.FirstNotRepeatingChar("google");
        System.out.println(num);
    }
}
