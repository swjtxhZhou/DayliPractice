package ToOffer.practice;

public class To51_mergeSort {
    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
     * 题目保证输入的数组中没有的相同的数字
     * 数据范围：
     * 	对于%50的数据,size<=10^4
     * 	对于%75的数据,size<=10^5
     * 	对于%100的数据,size<=2*10^5
     * 	例如：
     * 	输入：1，2，3，4，5，6，7.0
     * 	输出：7
     * 	因为有10，20，30，40，50，60，70，7个逆序对
     * 	考察点：数组
     * 	想法：两次遍历
     */
    //这样做超时了
    public int InversePairs(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int cnts = 0;
        for(int i=1;i<array.length;i++){
            for(int j=0;j<i;j++){
                if(array[i]<array[j]){
                    cnts++;
                }
            }
        }
        return cnts%1000000007;
    }
    //利用归并排序的性质
    /**
     * 在使序列有序化的过程中，如果需要交换数字说明他们就是逆序的，右边数字能使小于左边数字剩余的所有数字，即能与这些数字形成逆序对
     */
    public int InversePairs_merge(int[] array){
        if(array==null||array.length==0){return 0;}
        mergeSort(array,0,array.length-1);//注意细节这里之前是放入的array.length就一直报错超过数组长度。
        return cnt;
    }
    private int cnt =0;//全局变量
    //归并基
    private void mergeSort(int[] array,int begin,int last){
        if(begin==last){return;}
        int mid = ((last-begin) / 2)+begin;
        mergeSort(array,begin,mid);
        mergeSort(array,mid+1,last);
        merge(array,begin,mid,last);
    }
    //归并过程
    private void merge(int[] array,int begin,int mid,int last){
        //此时需要将array数组分为两组，其中begin-mid是有序的，mid+1-last是有序的
        int[] temp = new int[last-begin+1];//额外的空间来保证有序性
        //进行合并过程
        int i=0;
        int p1 = begin, p2 = mid+1;
        while(p1<=mid&&p2<=last){
            if(array[p1]>array[p2]){
                //如果左边的数字比右边大，将右边的数字加入到额外内存中
                cnt += mid-p1+1;
                cnt%=1000000007;//此时左边后面包括当前的数字都能和此时右边的数组形成逆序对
                temp[i++]=array[p2++];
            }else{
                temp[i++]=array[p1++];//这里不需要做处理
            }
        }
        //将剩余的数字放入temp中
        while(p1<=mid){
            temp[i++] = array[p1++];
        }
        while(p2<=last){
            temp[i++] = array[p2++];
        }
        for(int num:temp){
            array[begin++] = num;
        }
    }
    public static void main(String[] args){
        To51_mergeSort to51 = new To51_mergeSort();
        int[] array = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        int num = to51.InversePairs_merge(array);
    }
}
