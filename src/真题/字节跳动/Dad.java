package 真题.字节跳动;

public class Dad {
    public static int count =0;
    public static int insertSort(int[] a){
        int temp;
        for(int i=1;i<a.length;i++){
            if(a[i]<a[i-1]){
                count++;
                temp = a[i];
                int index = search(a,a[i],0,i-1);
                for(int j=i-1;j>=index;j--){
                    a[j+1] = a[j];
                }
                a[index] = temp;
            }
        }
        return count;
    }
    public static int search(int[] a,int target,int start,int end){
        for(int i=start;i<=end;i++){
            if(a[i]==target){
                return i;
            }
        }
        return end;
    }
    public static void main(String[] args){
        int[] a = {4,1,2,5,3};
        System.out.println(insertSort(a));
    }
}
