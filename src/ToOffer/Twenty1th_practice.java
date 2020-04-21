package ToOffer;

public class Twenty1th_practice {
    public int[] reOrderArray(int[] nums){
        if(nums.length==0){
            return null;
        }
        //判断数组中奇数的个数
        int count=0;
        for(int num:nums){
            if(isEven(num)){
                count++;
            }
        }
        int[] newNum = nums.clone();
        int i=0,j=count;
        for(int num:nums){
            if(num%2==1){
                newNum[i++]=num;
            }else{
                newNum[j++]=num;
            }
        }
        return newNum;
    }
    //判断是不是奇数
    private boolean isEven(int num){
        if(num%2==1){
            return true;
        }
        return false;
    }
}
