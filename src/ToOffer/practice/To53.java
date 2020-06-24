package ToOffer.practice;

public class To53 {
    /**
     * 统计一个数字在排序数组中出现的次数。
     * 传统想法是遍历整个数组然后用一个额外的内存计数
     * 思路：
     * （1）可以先遍历到第一个出现的位置，然后从末尾遍历到第一次出现的位置，两个位置相减
     * 上面这种方法虽然可以AC但是如果遇到大数据量的情况就会非常糟糕
     * 最佳的方法就是通过二分查找来找k的第一次出现的位置和k+1第一次出现的位置
     * 二分查找需要注意的问题，因为二分一定会返回一个位置，然后该位置不一定会是目标值的第一个位置要谨慎判断。
     */
    public int GetNumberOfK(int [] array , int k) {
        if(array==null||array.length==0){return 0;}
        int first =-1,last = -1;
        for(int i=0;i<array.length;i++){
            if(array[i]==k){
                first = i;
                break;
            }
        }
        for(int i=array.length-1;i>=0;i--){
            if(array[i] == k){
                last = i;
                break;
            }
        }

        return last-first+1;
    }

    //可以用二分查找来找k的第一次出现然后再找k+1的第一位
    public int GetNumberOfK_binarySearch(int [] array , int k) {
        if(array==null||array.length==0){
            return 0;
        }
        int first = binarySearch(array,k);
        //这里也有点问题就是如果K+1大于所有的值，那么就会出错
        int last = binarySearch(array,k+1);//这里如果没有k+1这个数，会定位到紧跟k的后面一位数，注意品二分查找的内容
        //这里要判断定位，如过k大于所有的值最终就会定位到数组末尾，如果没有k这个数，那么会定位到大于k的数的第一个位置。
        if(array[array.length-1]<k+1){
            return (first==array.length||array[first]!=k)?0:last-first+1;
        }
        return (first==array.length||array[first]!=k)?0:last-first;

    }
    private int binarySearch(int[] array,int k){
        int low =0,high = array.length-1;
        while(low<high){
            int mid = (high-low)/2+low;
            if(array[mid]>=k){
                //往前找
                high=mid;//这里不是mid-1，仔细品，因为如果中位数等于k并且可能是第一个
            }else{
                //往后找
                low = mid+1;
            }
        }
        return low;
    }
}
