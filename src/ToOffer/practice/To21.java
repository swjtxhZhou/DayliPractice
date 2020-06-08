package ToOffer.practice;

public class To21 {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * 可以在原数组上移动改变，但是时间复杂度会很高，一般不推荐
     * 利用新的空间来保存数组
     */
    //利用一个新的空间
    public void reOrderArray(int [] array) {
        if(array==null||array.length==0){
            return;
        }
        //判断奇数的数量
        int noEven=0;
        for(int num:array){
            if(!isEven(num)){
                noEven++;
            }
        }
        int[] clone = array.clone();
        int i=0,j=noEven;
        for(int num:clone){
            if(isEven(num)){
                array[j++]=num;
            }else{
                array[i++]=num;
            }
        }
    }
    private boolean isEven(int num){
        return num%2!=1;
    }
    //使用冒泡思想
    public void reOrderArray_bubble(int[] array){
        int n= array.length;
        for(int i=n-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(isEven(array[j])&&!isEven(array[j+1])){
                    int t = array[j];
                    array[j]=array[j+1];
                    array[j+1]=t;
                }
            }
        }
    }
}
