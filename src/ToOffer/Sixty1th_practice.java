package ToOffer;

import java.util.Arrays;

public class Sixty1th_practice {
    public boolean isContinus(int[] nums){
        if(nums.length<5)return false;
        int cnt =0;//赖子数量
        for(int num:nums){
            if(num==0){
                cnt++;
            }
        }
        Arrays.sort(nums);//默认是升序
        for(int i=cnt;i<nums.length-1;i++){
            if(nums[i+1]==nums[i])return false;
            cnt -= nums[i+1]-nums[i]-1;
        }
        return cnt<0;
    }
}
