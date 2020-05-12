package ToOffer;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Fifty6th {
    /**
     * 数组中只出现一次的数字
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次，找出这两个数。
     * 两个不相等的元素在位级表示上必定会有一位存在不同，将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。
     *位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
     * 依照这个思路，我们来看两个数（我们假设是AB）出现一次的数组。我们首先还是先异或，剩下的数字肯定是A、B异或的结果，这个结果的二进制中的1，表现的是A和B的不同的位。我们就取第一个1所在的位数，假设是第3位，接着把原数组分成两组，分组标准是第3位是否为1。如此，相同的数肯定在一个组，因为相同数字所有位都相同，而不同的数，肯定不在一组。然后把这两个组按照最开始的思路，依次异或，剩余的两个结果就是这两个只出现一次的数字。
     * diff &= -diff 得到出 diff 最右侧不为 0 的位，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开来。
     *
     */
    public void FindNumsAppearOnce(int[] nums, int num1[], int num2[]) {
        int diff = 0;
        for (int num : nums)
            diff ^= num;
        diff &= -diff;
        for (int num : nums) {
            if ((num & diff) == 0)
                num1[0] ^= num;
            else
                num2[0] ^= num;
        }
    }
    //HashMap的做法
    public void FindNumsAppearOnce2(int[] nums,int num1[],int num2[]){
        HashMap<Integer,Integer> map = new LinkedHashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,2);
            }else{
                map.put(num,1);
            }
        }
        int count =0;
        for(int num:nums){
            if(map.get(num)==1){
                if(count==0){
                    num1[0]=num;
                    count++;
                }else{
                    num2[0]=num;
                }
            }
        }
    }
}
