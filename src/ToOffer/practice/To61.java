package ToOffer.practice;

import java.util.Arrays;

public class To61 {
    /**
     * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
     *考察点：字符串，连续字符
     * 1、先判断是否有大小王，并记录其数量
     * 2、然后将numbers按升序排序
     * 3、如果是0就越过
     * 4、判断连续性，如果不连续判断两者之间差的数量为多少，如果大于赖子的数量就返回false，如果小于赖子的数量，可以消耗赖子（这一步从正向操作不好操作）
     * 5、将步骤4进行改进，遇到不连续就使用赖子来补，最后统计消耗赖子的数量，如果大于持有的赖子数量就返回false
     */
    public boolean isContinuous(int [] numbers) {
        if(numbers==null||numbers.length<5){return false;}
        int cnt = 0;
        Arrays.sort(numbers);
        for(int num:numbers){
            if(num==0)cnt++;
        }
        for(int i=cnt;i<numbers.length-1;i++){
            if(numbers[i+1]==numbers[i]){
                //存在相同的数字直接返回false
                return false;
            }
            cnt = cnt -(numbers[i+1]-numbers[i]-1);//如果前后两个相差超过了1就开始消耗赖子
        }
        return cnt>=0;
    }
}
