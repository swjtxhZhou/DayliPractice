package ToOffer;

public class Thirty9th_pracitce {
    public int moreThanHalfNum_solution(int[] nums){
        if(nums.length==0)return 0;
        int majority = nums[0];
        //如果有存在次数超过总数一半的数字，那么一定会是majority
        for(int i=0 ,cnt=1;i<nums.length;i++){
            cnt = nums[i]==majority?cnt+1:cnt-1;
            if(cnt==0){
                majority = nums[i];
                cnt =1;
            }
        }
        int cnt = 0 ;
        for(int val:nums){
            if(val == majority){
                cnt++;
            }
        }
        return cnt>nums.length/2?majority:0;
    }
}
