package ToOffer;

public class Three_practice {
    /**
     * 这里有一个条件就是数组里的数不会超过数组的长度，所以就能利用互换位置这一方法，当发现位置上有数字，判断有数字是否相同，否则就交换位置
     * @param nums
     * @param length
     * @param duplicate
     * @return
     */
    public boolean duplicate(int[] nums,int length,int[] duplicate){
        if(nums==null||nums.length==0){
            return false;
        }
        for(int i=0;i<length;i++){
            //先判断i是否等于nums[i]，如果不等于，然后判断nums[i]是否等于nums[nums[i]],如果不等于交换两个的位置，如果等于说明有重复存在
            while(nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    duplicate[0] = nums[i];
                    return true;
                }
                //交换nums[i]与nums[nums[i]]的位置
                Swap(nums,i,nums[i]);
            }
        }
        return false;
    }
    void Swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
