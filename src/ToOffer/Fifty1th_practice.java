package ToOffer;

public class Fifty1th_practice {
    public long cnt =0;
    public long InversePairs(int[] arr){
        if(arr==null||arr.length==0)return 0;
        return cnt;
    }
    //递归基
    public void MergeSort(int[] arr,int low,int high){
        if(high-low<1)return;
        int mid = low+(high-low)/2;
        MergeSort(arr,low,mid);
        MergeSort(arr,mid+1,high);
        Merge(arr,low,mid,high);
    }
    public void Merge(int[] arr,int low,int mid,int high){
        int[] temp = new int[high-low+1];//用来保存这次经过排序的有序序列
        int i = low,j=mid+1,k=0;
        while(i<=mid && j<=high){
            if(arr[i]<arr[j]){//前面的元素比后面的元素小，不做调整
                temp[k++] = arr[i++];
            }else{//前面的元素比后面的元素大，那么需要做调整
                cnt = cnt+(mid-i+1);
                temp[k++] = arr[j++];
            }
        }
        //把可能剩下没有添加的元素添加到temp，这一部分元素原来就是有序的
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=high){
            temp[k++] = arr[j++];
        }
        //将temp中的元素替换到arr对应的位置上
        for(int start=low,index = 0;start<=high;start++){
            arr[start] = temp[index++];
        }
    }

}
