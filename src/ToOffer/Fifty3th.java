package ToOffer;

public class Fifty3th {
    /**
     * 数字在排序数组中出现的次数
     * Input:
     * nums = 1, 2, 3, 3, 3, 3, 4, 6
     * K = 3
     *
     * Output:
     * 4
     */
    //使用二分法，查找第一个k的位置，再查找k+1的位置，传统二分查找不一定能找到第一个k值所在的位置，需要做一些改进。
    public int FindNumberOfK(int[] arr,int k){
        if(arr==null||arr.length==0)return -1;
        int first = BinarySearch(arr,k);//怎么保证找到的k是第一个？？？
        int last = BinarySearch(arr,k+1);

        return (first==arr.length||arr[first]!=k)?-1:last-first;
    }
    public int BinarySearch(int[] arr,int k){
        int high = arr.length;
        int low = 0;
        while(low<high){
            int m = low+(high-low)/2;
            if(k<=arr[m]){//只要小于等于就继续往前面走
                high = m;
            }else{
                low=m+1;
            }
        }
        return low;
    }

    //这个二分查找是针对没有重复的数组，不得行
    public int TraditionalBinarySearch(int[] arr,int k){
        int high = arr.length;
        int low = 0;
        while(low<high){
            int mid = low+(high-low)/2;
            if(arr[mid] == k){
                return mid;
            }else if(arr[mid]<k){
                low = mid+1;
            }else if(arr[mid]>k){
                high = mid-1;
            }
        }
        return -1;
    }
}
