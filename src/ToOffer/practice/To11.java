package ToOffer.practice;

public class To11 {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
     * 将旋转数组对半分可以得到一个包含最小元素的新旋转数组，以及一个非递减排序的数组。新的旋转数组的数组元素是原数组的一半，从而将问题规模减少了一半，这种折半性质的算法的时间复杂度为 O(logN)（为了方便，这里将 log2N 写为 logN）。
     * 此时问题的关键在于确定对半分得到的两个数组哪一个是旋转数组，哪一个是非递减数组。我们很容易知道非递减数组的第一个元素一定小于等于最后一个元素。
     */
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0)return 0;
        int l=0,h=array.length-1;
        int m = (l+h)/2;
        while(l<h){//这里没有考虑到出现重复数组的情况，即array[l]==array[m]==array[h]的情况，需要单独考虑
            if(array[l]==array[m]&&array[m]==array[h]){
                return minNumber(array,l,h);
            } else if(array[m]<=array[h]){//为什么不能是array[l]>array[m]?这里应该只能去根据非递减序列的性质去判断，而不是去判断哪一段是旋转序列
                //前半段是旋转序列，l不变，h=m;
                h=m;
                m=(l+h)/2;
            }else{
                //后半段是旋转序列
                l=m+1;
                m=(l+h)/2;
            }
        }
        return array[l];
    }
    private int minNumber(int[] array,int l,int h){
        //顺序查找
        for(int i=l;i<h;i++){
            if(array[i]>array[i+1]){
                return array[i+1];
            }
        }
        //如果循环中没有返回，说明第一个就是最小值
        return array[l];
    }
}
