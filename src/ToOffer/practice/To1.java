package ToOffer.practice;

public class To1 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int[] nums =  new int[length];
        int index=0;
        for(int i=0 ; i<length ; i++){
            if(nums[numbers[i]]!=0){
                duplication[index++]=numbers[i];
            }else{
                nums[numbers[i]]=1;
            }
        }
        return duplication[0]!=0;
    }

    //更加节约内存的方法
    public boolean duplicate_memoryOptimzing(int numbers[],int length,int [] duplication){
        //用numbers自身来存
        if(numbers==null||length==0){
            return false;
        }
        for(int i=0;i<length;i++){
            while(numbers[i]!=i){
                //把numbers[i]的值放在其value值大小相同的位置上
                if(numbers[i]==numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
                //交换位置
                swap(numbers,i,numbers[i]);
            }
        }
        return false;
    }
    private void swap(int numbers[],int i,int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
