package 面前练习.美团点评8_22面前练习;

import ToOffer.Utils.ListNode;

//美团常问的排序算法
public class Sort {
    public static void main(String[] args){
        int[] nums = new int[]{7,6,5,4,3,2,1};
        int[] res = mergeSort(nums);
        for(int val:res){
            System.out.print(val+", ");
        }
    }
    //冒泡排序，插入排序，选择排序的时间复杂度是O（n2），其中选择排序不是稳定排序
    //快速排序平均时间复杂度为O（nlogn），最坏的情况为O（n2），不稳定排序
    //归并排序平均时间复杂度为O（nlogn），是稳定排序

    //冒泡排序
    public static int[] bubbleSort(int[] nums){
        if(nums==null||nums.length==0){
            return null;
        }
        //比较相邻的两个元素，如果前一个比后一个大，交换之
        //第一趟，将最大的数移动数组最后一位，第二趟，把最大的数移动道数组的倒数第二位。。因此需要n-1趟排序
        //时间复杂度为O（n2），空间复杂度为O（1），因为没有使用额外的空间保存
        //遍历的长度需要-1是因为比较的时候是使用nums[j]和nums[j+1],如果不减1，会导致数组越界的情况
        //可以使用优化，如果一趟排序下来没有元素移动了说明整个数组都是有序的了
        boolean flag = false;
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    //交换位置
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = true;
                }
            }
            while(!flag){
                break;
            }
        }
        return nums;
    }

    //选择排序
    public static int[] selectSort(int[] nums){
        if(nums==null||nums.length==0){
            return null;
        }
        //选择排序是每次确定一个当前的位置的最小值
        //每一次遍历待排序的序列，记录最小（大）值得下标，和待排序得第一个元素比较，如果小（大）与待排序得第一个元素，则交换
        //选择排序是不稳定得
        //举个例子，序列5 8 5 2 9，我们知道第一遍选择第1个元素5会和2交换，那么原序列中2个5的相对前后顺序就被破坏了，所以选择排序不是一个稳定的排序算法。
        //时间复杂度为O（n2）,空间复杂度为O（1），没有使用多余得额外空间
        for(int i=0;i<nums.length-1;i++){
//            int min = nums[i];//设定当前值为最小值
            int minindex = i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[minindex]>nums[j]){
//                    min = nums[j];
                    minindex = j;//记录最小值得下标
                }
            }
            if(minindex!=i){
                //说明找到了最小值，交换
                int temp = nums[i];
                nums[i] = nums[minindex];
                nums[minindex] = temp;
            }
        }
        return nums;
    }

    //插入排序
    public static int[] insertSort(int[] nums){
        if(nums==null||nums.length==0){
            return null;
        }
        //插入排序是维护一个有序数组和一个无序数组，每次选取无序数组得第一个元素，在有序数组中找到插入位置，插入位置之后得所有元素往后移动
        //插入排序是稳定得，因为在选择插入位置时是比较是否比当前位置更小，如果不是就插在该位置上，所以如果元素相等，那么插入得位置就是在相等元素得末尾，没有改变相同元素得相对位置
        //关键点，在找插入位置的同时也在移动元素，使用while，而不是for来遍历
        //时间复杂度是O（n2），空间复杂度为O（1），没有使用额外空间
        for(int i=1;i<nums.length;i++){
            //选取无序数组得第一个元素
            int cur = nums[i];
            //有序数组得末尾位置
            int index = i-1;
            //找到插入位置
            while(index>=0&&nums[index]>cur){
                //只要有序数组没有遍历完，并且当前位置得元素比无序数组得第一个元素大，就继续往前找插入位置
                nums[index+1] = nums[index];//当前有序数组的元素比无序数组的第一个元素更大，令有序数组的元素往后移动一位
                index--;//继续往前移动
            }
            //此时nums[index+1]的位置应该nums[index+2]的值
            //将待排序元素插入新的位置
            nums[index+1] = cur;
        }
        return nums;
    }

    //快速排序
    public static int[] quickSort(int[] nums){
        //在实际应用当中快速排序确实也是表现最好的排序算法。冒泡排序虽然高端，但其实其思想是来自冒泡排序，冒泡排序是通过相邻元素的比较和交换把最小的冒泡到最顶端，而快速排序是比较和交换小数和大数，这样一来不仅把小数冒泡到上面同时也把大数沉到下面。
        //快速排序是选定一个基准元素，使用两个游标分别从一个从最左开始和从右开始与基准数据比较，分别在左边找到比基准元素大的（左边的元素应该都要比基准数据小或者相等），在右边找到比基准元素小的（右边的元素应带都要比基准数据大或者相等）
        //在交换了以基准数据划分的左右元素之后，需要让基准数据放在正确的位置上，在交换结束后，左游标的位置就是基准元素最后要在的位置
        //分别对基准元素的左边子数组和右边子数组进行递归
        //时间复杂度O（nlogn）,最差时间复杂度O（n2）-每次选取基准数据就是最大或者最小值，这样等同于冒泡排序
        //空间复杂度，快速排序使用的空间是O（1），真正消耗空间的是递归调用，最优空间复杂度是每一次都是平分数组O（logn），最差时间复杂度是O(n)-等同于冒泡排序
        if(nums==null||nums.length==0){
            return null;
        }
        quick(0,nums.length-1,nums);
        return nums;
    }
    public static void quick(int begin,int last,int[] nums){
        if(begin>=last){
            return;
        }
        //选择基准元素，最左边的元素,基准元素是用来把当前数组区分为比基准元素大的部分和比基准元素小的部分
        int temp = nums[begin];
        int i = begin+1;
        int j = last;
        //根据基准元素，交换元素
        while(i<j) {
            //右边先走，因为选取的第一个元素为基准数据，所以左边元素第一次要交换的数据肯定是第一个
            while (i < j && nums[j] >= temp) {
                //右边的元素比基准元素大或者等于，则往前走
                j--;
            }
            while (i < j && nums[i] <= temp) {
                //左边的元素比基准元素小或者等于，则往后走
                i++;
            }
            //交换元素
            if (i < j) {
                swap(i, j, nums);
            }
        }
        //让基准元素就位
        nums[begin] = nums[i];
        nums[i] = temp;
        //对左边进行分割,要剔除掉基准元素
        quick(begin,i-1,nums);
        //对右边进行分割
        quick(i+1,last,nums);

    }
    public static void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //归并排序
    public static int[] mergeSort(int[] nums){
        if(nums==null||nums.length==0){
            return null;
        }
        res = new int[nums.length];
        partition(0,nums.length-1,nums);
        return nums;
    }
    public static int[] res;
    //归并基
    public static void partition(int begin,int last,int[] nums){
        if(begin>=last){
            return;
        }
        int mid = begin+(last-begin)/2;
        partition(begin,mid,nums);
        partition(mid+1,last,nums);
        merge(begin,mid,last,nums);
    }
    //合并数组
    public static void merge(int begin,int mid,int last,int[] nums){
        int start1 = begin;
//        int j = last;
        int start2 = mid+1;
        int index = begin;
        for(int i=begin;i<=last;i++){
            res[i] = nums[i];//将数组拷贝到备用数组上面
        }
        //将两个子数组【begin，mid】【mid+1,last】合并
        //在合并的过程中不能使用额外空间来作为最终结果的保存值，因为每次合并后的结果没有传递到下一次递归的比较中
        while(start1<=mid && start2<=last){
            nums[index++] = res[start1]>res[start2]?res[start2++]:res[start1++];
        }
        while(start1<=mid){
            nums[index++] = res[start1++];
        }
        while(start2<=last){
            nums[index++] = res[start2++];
        }
    }

    //选择排序对链表进行排序
    public static ListNode selectSort(ListNode head){
        if(head==null){
            return null;
        }
        //不使用新的节点来创建链表
        //交换两个节点的val值
        ListNode cur = head;//当前需要交换的位置
        ListNode min ;//从当前位置向后遍历得到的最小节点
        ListNode temp;//遍历从当前位置到链表最后使用
        while(cur!=null){
            temp = cur.next;
            min = cur;
            while(temp!=null){
                if(temp.val<min.val){
                    min = temp;
                }
                temp = temp.next;
            }
            //找到了最小值，将val与cur交换
            if(min!=cur){
                int t = min.val;
                min.val = cur.val;
                cur.val = t;
            }
            //继续找下一个最小值
            cur = cur.next;
        }
        return head;
    }



}
