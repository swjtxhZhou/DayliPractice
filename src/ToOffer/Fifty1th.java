package ToOffer;

public class Fifty1th {
    /**
     * 数组中的逆序对
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     */
    private long cnt = 0;
    private int[] tmp;  // 在这里声明辅助数组，而不是在 merge() 递归函数中声明

    public int InversePairs(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return (int) (cnt % 1000000007);
    }

    private void mergeSort(int[] nums, int l, int h) {//递归基
        if (h - l < 1)
            return;
        int m = l + (h - l) / 2;//其实就是(h+l)/2
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, h);
        merge(nums, l, m, h);
    }

    private void merge(int[] nums, int l, int m, int h) {
        int i = l, j = m + 1, k = l;
        while (i <= m || j <= h) {//低位小于中间数，中间数小于高位
            if (i > m)
                tmp[k] = nums[j++];
            else if (j > h)
                tmp[k] = nums[i++];
            else if (nums[i] <= nums[j])
                tmp[k] = nums[i++];
            else {
                tmp[k] = nums[j++];
                this.cnt += m - i + 1;  // nums[i] > nums[j]，说明 nums[i...mid] 都大于 nums[j]
            }
            k++;
        }
        for (k = l; k <= h; k++)
            nums[k] = tmp[k];
    }


    private void MergeSort(int[] array, int start, int end){
        if(start>=end)return;
        int mid = (start+end)/2;
        MergeSort(array, start, mid);
        MergeSort(array, mid+1, end);
        MergeOne(array, start, mid, end);
    }
    //那一部分开始排序？？？
    private void MergeOne(int[] array, int start, int mid, int end){
        int[] temp = new int[end-start+1];//新建的temp把该次排序的数组有序的存放
        int k=0,i=start,j=mid+1;
        while(i<=mid && j<= end){
//如果前面的元素小于后面的不能构成逆序对
            if(array[i] <= array[j])
                temp[k++] = array[i++];//按序往temp里添加数字
            else{
//如果前面的元素大于后面的，那么在前面元素之后的元素都能和后面的元素构成逆序对
                temp[k++] = array[j++];//因为前面的元素比后面的元素大，那么后面这个元素就是前面的元素加上后面这个元素的最小值
                cnt = (cnt + (mid-i+1))%1000000007;//mid-i是i到j之间的元素数量，加上自身就是mid-i+1;
            }
        }
        /**
         * 这个是归并排序一次合并排序的最后步骤，为了防止最后某一个数组中还剩余有多个元素需要存放到新的已排序的数组中，
         * 比如对0，6，7，8和1，2，3，4进行归并，最后会剩下6，7，8
         */
        while(i<= mid)//
            temp[k++] = array[i++];
        while(j<=end)
            temp[k++] = array[j++];
        for(int l=0; l<k; l++){
            array[start+l] = temp[l];//把排好序的替代原始数组中元素的序列
        }
    }
    public long InversePairs1(int [] array) {
        MergeSort(array, 0, array.length-1);
        return cnt;
    }
}
