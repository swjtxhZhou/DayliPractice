package Algorithem.基础排序算法;

public class Sort_practice {
    public static void main(String[] args){
        int[] nums = new int[]{1,4,5,3,6,8,7};
        for(int num:nums){
            System.out.print(num+", ");
        }
        System.out.println();
//       Sort_practice.bubble_sort(nums);
//        Sort.bubbleSort(nums);
//        Sort_practice.insert_sort_quick(nums);
//        Sort_practice.select_sort(nums);
//        Sort_practice.quick_sort(nums);
        Sort_practice.merge_sort(nums);
        for(int num:nums){
            System.out.print(num+", ");
        }
//        System.out.println(results);
    }
    //冒泡排序
    public static int[] bubble_sort(int[] nums){
        if(nums==null||nums.length==0){
            return null;
        }
        for(int i=0;i<nums.length-1;i++){
//            boolean flag = true;
            for(int j=1;j<nums.length-1-i;j++){
                if(nums[j-1]>nums[j]){//采取升序排序
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
//                flag = false;
            }
//            if(flag){
//                break;
//            }
        }
        return nums;
    }
    //插入排序
    public static int[] insert_sort(int[] nums){
        if(nums==null||nums.length==0){
            return null;
        }
        //维护一个有序序列和一个无序序列
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                //无序数组的第一个比有序数组的最后一个更小
                int temp = nums[i];
                int index = search(nums,nums[i],0,i-1);
                //将index这个位置到有序数组最后一位的元素往后移动一位
                for(int j=i-1;j>=index;i--){
                    nums[j+1] = nums[j];
                }
                nums[index] = temp;
            }
        }
        return nums;
    }
    private static int search(int[] nums,int target,int begin,int last){
        for(int i = begin;i<=last;i++){
            if(nums[i] == nums[target]){
                return i;
            }
        }
        return last;
    }
    //插入排序优化版
    public static int[] insert_sort_quick(int[] nums){
        if(nums==null||nums.length==0){
            return null;
        }
        for(int i=1;i<nums.length;i++){
            int value = nums[i];//无序数组第一位
            int j=i-1;//有序数组最后一位
            for(;j>=0;j--){
                if(nums[j]>value){
                    nums[j+1] = nums[j];
                }else{
                    break;
                }
                nums[j] = value;
            }
        }
        return nums;
    }
    //选择排序
    public static int[] select_sort(int[] nums){
        if(nums==null||nums.length==0){
            return null;
        }
        for(int i=0;i<nums.length;i++){
//            int min = nums[i];
            int min =i;//设置当前位是最下数
            for(int j=i+1;j<nums.length;j++){
                if(nums[min]>nums[j]){
//                    min=nums[j];
                    min = j;//更新最小位
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
        return nums;
    }
    //快速排序
    public static int[] quick_sort(int[] nums){
        if(nums==null||nums.length==0){
            return null;
        }
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    private static void quickSort(int[] nums,int lo,int hi){
        //递归的返回条件
        if(hi<=lo)return;
        //在选取一个基准数据的过程中，将会选取改段第一个数字为基准，并找出两个子序列，分别位于其左边和右边，并返回这个基准的新下标
        int index = partition(nums,lo,hi);
        //继续对基准的左边序列进行快排操作
        quickSort(nums,lo,index-1);
        //继续对基准的右边序列进行快排操作
        quickSort(nums,index+1,hi);
    }
    private static int partition(int[] nums,int lo,int hi){
        //指定两个指针
        int before = lo+1;
        int after = hi;
        int base = nums[lo];
        while(true){
            while(nums[before]<base){
                //从左往右遍历，只要遇到比base小的数就继续往后走
                if(before==hi)break;
                before++;
            }
            while(nums[after]>base){
                //从右往左遍历，只要遇到比base大的数就往前走
                if(after==lo)break;
                after--;
            }
            //结束循环的动作
            if(after<=before)break;
            //交换两个指针的元素
            int temp = nums[before];
            nums[before] = nums[after];
            nums[after] = temp;
        }
        //将基准数字放在对应位置上,后指针指向的位置！！！
        int temp = nums[lo];
        nums[lo] = nums[after];
        nums[after] = temp;
        return after;
    }

    public static int[] merge_sort(int[] nums){
        //先把辅助数组初始化，在进行操作，不然会产生空指针报错。
        auk = new int[nums.length];
        mergerSort(nums,0,nums.length-1);
        return nums;
    }
    private static void mergerSort(int[] nums,int lo,int hi){
        if(lo>=hi)return;
        //归并基
        int mid = (lo+hi)/2;
        //分
        mergerSort(nums,lo,mid);
        mergerSort(nums,mid+1,hi);
        //合
        merge(nums,lo,hi,mid);
    }
    //归并排序需要一个全局变量
    public static int[] auk;
    private static void merge(int[] nums,int lo,int hi,int mid){
        //合并的过程,需要备份一个的数组,这个数组是全局变量
        for(int i=lo;i<=hi;i++){
//            System.out.println(i+" "+nums[i]);
            auk[i] = nums[i];
        }
        int first = lo;//第一个指针
        int second = mid+1;//第二个指针
        for(int i=lo;i<=hi;i++){
            if(first>mid){
                //前面那一段都走完了，
                nums[i] = auk[second++];
            }else if(second>hi){
                //后面那一段走完了
                nums[i] = auk[first++];
            }else if(auk[first]>auk[second]){
                //哪个小就先赋给数组
                nums[i] = auk[second++];
            }else{
                nums[i] = auk[first++];
            }
        }
    }
}
