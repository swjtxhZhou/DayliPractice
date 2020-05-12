package ToOffer;

public class Fifty8th_practice {
    /**
     * 旋转再旋转
     */
    //主方法
    public String ReverseSentence(String str){
        int length = str.length();//记录长
        int i=0,j=0;
        char[] arr = str.toCharArray();
        //反转单词
        while(j<=length){
            if(j==length||arr[j]==' '){//因为arr[length]会越界所以需要把j==length判断放在前面，当j==length是表明是最后一个单词，所以不应该用空格来判断。
                Reverse(arr,i,j-1);//j-1，旋转单词的时候需要把空格去掉
                i = j+1;
            }
            j++;
        }
        Reverse(arr,0,length-1);
        return new String(arr);
    }

    private void Reverse(char[] arr,int i,int j){
        while(i<j){
            Sweap(arr,i++,j--);
        }
    }
    //旋转方法
    private void Sweap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
