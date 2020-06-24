package ToOffer.practice;

import java.util.HashMap;
import java.util.Map;

public class To56 {
    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * 考察点：数组
     * 思路：至少需要遍历一次，因为是找重复一次很容易想到一个萝卜一个坑，因为是数组不能采取一个萝卜一个坑的形式。这种可能需要借助额外内存来保存出现次数，set不适合用来计数，选择map来记录出现次数。
     * 这道题麻烦的一点就是存在两个数而不是一个数，于是要去筛选出出现一次的数，然后还要把两个数拿出来再赋值
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null||array.length==0){return;}
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<array.length;i++){
            if(!map.containsKey(array[i])){
                map.put(array[i],1);
            }else{
                map.put(array[i],2);
            }
        }
        int[] nums = new int[2];
        int i=0;
        for(int num:map.keySet()){
            if(map.get(num)==1){
                nums[i++]=num;
            }
        }
        num1[0] = nums[0];
        num2[0] = nums[1];
    }
    //两个不相等得元素在位级表示上必定会有一位存在不同，将数组得所有元素异或得到得结果为不存在重复的两个元素异或的结果
    //diff &= -diff会得到最右侧不为0的位，就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开
    public void FindNumAppearOnce(int[] num,int num1[],int num2[]){
        int diff=0;
        for(int number:num){
            diff ^=number;
        }
        diff &= -diff;
        for(int number:num){
            if((number & diff)==0){
                //不能匹配最右侧那位
                num1[0] ^= number;//0和任何数异或得到和异或对象一样
            }else{
                //能匹配上最右侧那位
                num2[0] ^= number;
            }
        }
    }
}
