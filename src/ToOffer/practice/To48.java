package ToOffer.practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class To48 {
    /**
     * 最长不含重复字符的子字符串
     * 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
     * 考点：字符串，不重复
     * 初始想法：使用26长的数组来代表26个字符，使用队列来维持序列的有序性。这样行不通，因为重复出现之后记录重复次数的int数组不会改变，即使从queue中已经弹了出来
     *
     * 连续字符串，不重复——》滑动窗口
     *
     */
    public int longestSubStringWithoutDuplication(String str) {
        if(str==null||str.length()==0){
            return 0;
        }
        int curLen = 0;//滑动窗口的大小
        int maxLen = 0;//动态更新最大的窗口指
        int[] preIndexs= new int[26];
        Arrays.fill(preIndexs,-1);
        for(int curI = 0;curI<str.length();curI++){
            int c = str.charAt(curI)-'a';//用c来表示距离a的ASCLL码的差，这样就节约了内存，只需要大小26的数组就能将26个字母表示出来
            int preI = preIndexs[c];//这里是找出该字母在最后一次出现的位置，如果为-1则是第一次出现
            if(preI == -1||curI-preI>curLen){//如果字母是第一次出现，就扩大滑动窗口的大小，如果不是第一次出现，用现在的位置减去最后一次出现的位置对比是否大于滑动窗口的大小，如果大于则不用做出改变，继续扩大滑动窗口的大小，如果小于就要另外处理
                curLen++;
            }else{
                //更新最大窗口长度
                maxLen = Math.max(maxLen,curLen);
                //这次需要做出调整的新的滑动窗口长度
                curLen = curI-preI;
            }
            //更新该字符的新的位置
            preIndexs[c] = curI;
        }
        return Math.max(maxLen,curLen);//这里还需要做出对比是因为，如果后续可能会出现没有更新maxLen的情况而curLen会一直增加（从上一次重复更新了滑动窗口到字符末尾没有出现重复就不会更新maxLen）
    }

}
