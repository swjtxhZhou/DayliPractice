package ToOffer;

import java.util.Arrays;

public class Forty8th {
    /**
     * 最长不含重复字符的子字符串
     * 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
     *
     * 动态规划
     * 动态规划，用f(i)表示以i个字符结尾不包含重复子字符串的最长长度，从左向右扫描
     *
     * 1、若第i个字符在之前没出现过，则 f(i) = f(i-1) + 1;
     *
     * 2、若第i个字符在之前出现过，
     *
     * 计算第i个字符距离上次出现之间的距离为d
     *
     * (a)若d <= f(i-1)，则说明第i个字符上次出现在f(i-1)对应的不重复字符串之内，那么这时候更新 f(i) = d
     *
     * (b)若d > f(i-1)，则无影响,f(i) = f(i-1) + 1
     */
    public int longestSubStringWithoutDuplication(String str) {
        int curLen = 0;
        int maxLen = 0;
        int[] preIndexs = new int[26];//用一个数组来维护对应字母上一次出现的位置
        Arrays.fill(preIndexs, -1);
        for (int curI = 0; curI < str.length(); curI++) {
            int c = str.charAt(curI) - 'a';
            int preI = preIndexs[c];
            if (preI == -1 || curI - preI > curLen) {//第一个是判断第一次出现，第二个是判断到上一次出现的距离是否比现在的窗口更大，如果更大就不用考虑字符重复
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = curI - preI;
            }
            preIndexs[c] = curI;//记录当前这个字符的最新的位置
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }
}
