package ToOffer.practice;

import java.util.ArrayList;

public class To57_2 {
    /**
     * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
     * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
     * 考察点：数组
     * 特点：连续数字，连续数字之和，所有的可能结果，至少包含两个数
     * 想法：
     * 1、使用一个动态的滑动窗口，从开始遍历到结尾
     * 2、如果滑动窗口的值小于目标值就扩大滑动窗口范围，从后扩
     * 3、如果滑动窗口的值大于目标值就缩小滑动窗口范围，从前面缩
     */
    //超时间了
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        //0不是正数，所以sum不能为0，也不能为1，因为至少包含两个数
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(sum<=1)return lists;
        int currentSum =3;
        for(int first=1,last=2;last<sum;){
            if(currentSum<sum){
                //滑动窗口的值比sum小，last往后移
                last++;
                currentSum+=last;
            }else if(currentSum>sum){
                currentSum-=first;
                first++;
            }else if(currentSum==sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=first;i<=last;i++){
                    list.add(i);
                }
                lists.add(list);
                currentSum-=first;
                first++;
                last++;
                currentSum+=last;
            }
        }
        return lists;

    }
}
