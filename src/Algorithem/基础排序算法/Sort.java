package Algorithem.基础排序算法;

import java.util.HashMap;

public class Sort {

    //冒泡排序
    public static void bubbleSort(Comparable[] a){
        int flag;
        Comparable temp;
        for(int i=0;i<a.length-1;i++){
            flag=0;
            for(int j=1;j<a.length-1-i;j++){
                if(a[j].compareTo(a[j-1])<0){//升序
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
                flag = 1;
            }
            if(flag==0){
                return;//没有交换，中断循环
            }
        }
    }
    //插入排序，属于内部排序法，对于欲排序的元素以插入的方式找寻该元素的适当位置，以达到排序的母的。
    //基本思想，把n个待排序的元素看成一个有序表和无序表，开始时有序表只包含一个元素，无序表中包含n-1个元素，排序过程中每次从无序表中取出第一个元素，把排序码依次与有序表元素排序码比较，将它插入到有序表中适当的位置，成为新的有序表
    public static void insertionSort(Comparable[] a){
        Comparable temp;
        int j;
        for(int i=1;i<a.length;i++){
            temp = a[i];//无序表第一个元素
            for(j=i;j>0&&temp.compareTo(a[j-1])<0;j--){
                a[j]=a[j-1];//先将大的元素都向右移动，减少一半交换次数
            }//经过循环找到了位置
            a[j]=temp;
        }
    }
    //二分插入排序，使用二分查找找到插入点，然后进行移位
    public static void insertSort_BinarySort(Comparable[] a){
        Comparable temp;
        int j;
        for(int i=1;i<a.length;i++){
            if(a[i].compareTo(a[i-1])<0){
                //无序表第一个数比有序表的最后一个数要小
                temp = a[i];
                int index = binarySearch(a,a[i],0,i-1);//这里的查找范围就是有序表的范围
                for(j=i-1;j>=index;j--){
                    a[j+1]=a[j];//把要插入的位置的后面所有元素往后移动
                }
                a[index] = temp;
            }
        }

    }
    private static int binarySearch(Comparable[] a,Comparable target,int start,int end){
        int mid;
        while(start<=end){
            mid =(start+end) >> 1;//>>右移运算符，所有位往右移动一位，相当于除以2.
            if(target.compareTo(a[mid])<0){
                //target比a[mid]还要小，继续往前半段二分
                end = mid-1;
            }else{
                start = mid;
            }
        }
        return start;
    }

    //选择排序，，属于内部排序，按指定的规则选出某一元素，在依规定交换位置后达到排序的目的。
    //选择排序一共有（数组大小-1）轮排序，每一轮排序又是一个循环
    /**
     * 循环的规则：
     * 1、假定当前这个数是最小数
     * 2、然后和后面每个数比较，若有更小的重新确定最小数，得到下标
     * 3、遍历到数组最后时就得到本轮最小数和下标
     * 4、交换
     */
    public static void selectionSort1(Comparable[] a){
        int min;
        Comparable temp;
        for(int i=0;i<a.length;i++){
            min=i;//假设当前位置的数就是最小数的坐标（最小数是相对于该坐标以后的数而言的）
            for(int j=i+1;j<a.length;i++){
                if(a[j].compareTo(a[min])<0){
                    min = j;
                }
            }
            temp = a[min];
            a[min] = a[i];
            a[i] =temp;
        }
    }

    //希尔排序
    /**
     * 希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更快的版本，也称缩小增量排序
     * 基本思想：希尔排序是按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量减少，每组包含的关键词越来越多，当增量减至1时，整个文件被分成一组，算法结束。
     */
    public static void shellSort(Comparable[] a){
        int h=1;//增量大小
        Comparable temp;
        while(h<a.length/3){
            h = h*3+1;
        }
        while(h>=1){
            for(int i=h;i<a.length;i++){
                for(int j=i;j>=h&&a[j].compareTo(a[j-h])>0;j-=h){
                    temp = a[j];
                    a[j] = a[j-h];
                    a[j-h] = temp;
                }
            }
            h/=3;
        }
    }
    //堆排序
    /**
     * 堆排序的基本思想：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。将其与末尾元素进行交换，此时末尾元素就是最大值了。然后将剩余n-1个元素重新构造一个堆，这样会得到n个元素的次小值。如此反复执行，就能得到一个有序序列。
     */
    public static void heapSort(Comparable[] a) {
        int length = a.length;
        Comparable temp;
        for (int k = length / 2; k >= 1; k--) {
            sink(a, k, length);
        }
        while (length > 0) {
            temp = a[0];
            a[0] = a[length - 1];
            a[length - 1] = temp;
            length--;
            sink(a, 1, length);
        }
    }
    private static void sink(Comparable[] a, int k, int n) {
        Comparable temp;
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && a[j - 1].compareTo(a[j]) < 0) {
                j++;
            }
            if (a[k - 1].compareTo(a[j - 1]) >= 0) {
                break;
            }
            temp = a[k - 1];
            a[k - 1] = a[j - 1];
            a[j - 1] = temp;
            k = j;
        }
    }

    //归并排序
    /**
     * 利用归并的思想实现的排序方法。该算法采用分治策略（将大的问题分成一些小的问题然后递归求解。治的阶段则将分的阶段得到的结果修补在一起，即分而治之）
     */
    private static Comparable[] aux;// 自顶向下
    public static void mergeSort(Comparable[] a) {
        aux = new Comparable[a.length];
        mergeSort(a, 0, a.length - 1);
    }
    public static void mergeSort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = (lo + hi) >>> 1;
        mergeSort(a, lo, mid);
        mergeSort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];//将此次的子段备份
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {//这是处理低位的已经全部加入到序列中，另一边是有序的，所以挨个加入到序列中
                a[k] = aux[j++];
            } else if (j > hi) {//高位的已经全部加入到序列中。挨个把低位的序列加入到序列中
                a[k] = aux[i++];
            } else if (aux[j].compareTo(aux[i]) < 0) {//低位的比高位的更大
                a[k] = aux[j++];//将高位的放入该位置
            } else {//低位的比高位的更小
                a[k] = aux[i++];//将低位的放入该位置
            }
        }
    }

    //快速排序
    /**
     * 对冒泡排序的一种改进
     * 基本思想：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都小，然后按此方法对两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到有序序列。
     * ①先从队尾开始向前扫描且当low < high时,如果a[high] > tmp,则high–,但如果a[high] < tmp,则将high的值赋值给low,即arr[low] = a[high],同时要转换数组扫描的方式,即需要从队首开始向队尾进行扫描了
     *   ②同理,当从队首开始向队尾进行扫描时,如果a[low] < tmp,则low++,但如果a[low] > tmp了,则就需要将low位置的值赋值给high位置,即arr[low] = arr[high],同时将数组扫描方式换为由队尾向队首进行扫描.
     *   ③不断重复①和②,知道low>=high时(其实是low=high),low或high的位置就是该基准数据在数组中的正确索引位置.
     */
    public static void quickSort(Comparable[] a) {
        quickSort(a, 0, a.length - 1);
    }
    public static void quickSort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);//基准数据的下标位置
        quickSort(a, lo, j - 1);
        quickSort(a, j + 1, hi);
    }
    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable temp;
        Comparable v = a[lo];//每次都将序列的最低位的数据当作基准数据，
        while (true) {
            while (a[++i].compareTo(v) < 0) {//头指针往后走，如果遇到比基准数据小的继续往后走，否则跳出while循环
                if (i == hi) {
                    break;
                }
            }
            while (v.compareTo(a[--j]) < 0) {//尾指针往前走，如果遇到比基准数据大的继续往前走，否则跳出while循环
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {//两个指针相遇了就跳出了循环
                break;
            }//将头指针指向比基准数据大的元素与尾指针指向比基准数据小的元素位置交换
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }//此时将基准数据放在它应该在的位置上
        temp = a[lo];
        a[lo] = a[j];
        a[j] = temp;
        return j;//返回基准数据的下标
    }


}
