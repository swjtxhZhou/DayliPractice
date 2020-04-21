package ToOffer;

import java.util.Random;
import static Utils.StringUtils.*;
/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *
 * 对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。本题要求找出重复的数字，因此在调整过程中，如果第 i 位置上已经有一个值为 i 的元素，就可以知道 i 值重复。
 *
 * 以 (2, 3, 1, 0, 2, 5) 为例，遍历到位置 4 时，该位置上的数为 2，但是第 2 个位置上已经有一个 2 的值了，因此可以知道 2 重复：
 */
public class Three {
    public boolean duplicate(int[] nums,int length,int[] duplication){
        if (nums == null || length == 0) {
            return false;
        }
        /**
         * 遍历整个序列，
         * 1,如果i这个位置上的数字不是i，
         * 1.1，判断i这个位置上的数是否与该位置所存的数字对应的位置上是否相同，若相同则会找到重复的数字
         * 1.2，若不相同，将当前的数字存储到该数字对应的位置上面
         */
        for(int i=0; i<length;i++){
            while(nums[i] != i){

                if(nums[i] == nums[nums[i]]){
                    duplication[0] = nums[i];
                    return true;
                }

                swap(nums,i,nums[i]);
            }
        }
        return false;
    }

    /**
     * 将位置i和位置j上的数字交换
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums ,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public static void main(String[] args){
        Three three = new Three();
        int[] nums = new int[10000];
        int[] duplication = new int[100];
        Random rand = new Random(47);
        for(int i=0;i<nums.length;i++){
            nums[i] = rand.nextInt(10000);
        }
        println("是否有重复："+three.duplicate(nums, nums.length,duplication));
        println("重复的数字："+duplication[0]);
    }
}
