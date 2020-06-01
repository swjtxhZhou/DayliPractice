package ToOffer.practice;

public class To5 {
    /**
     * 将一个字符串中的空格替换成 "%20"。
     *
     * Input:
     * "A B"
     *
     * Output:
     * "A%20B"
     */
    //在原来字符串上面做工作
    public String replaceSpace(StringBuffer str) {
        //先判断空格的个数
        if(str==null||str.length()==0){return "";}
        int length = str.length();
        for(int i=0;i<length;i++){
            if(str.charAt(i)==' '){
                str.append("  ");
            }
        }
        //用两个指针,一个从原始数组的末尾位置从后往前走，一个从新数组的末尾位置从后往前走
        int i=length-1,j=str.length()-1;
        while(i>=0&&i<j){
            char c = str.charAt(i--);
            if(c!=' '){
                //搬移到最后一个位置
                str.setCharAt(j--,c);
            }else{
                str.setCharAt(j--,'0');
                str.setCharAt(j--,'2');
                str.setCharAt(j--,'%');
            }
        }
        return str.toString();
    }
    public static void main(String[] args){
        To5 to5 = new To5();
        System.out.println(to5.replaceSpace(new StringBuffer("hello world")));
    }
}
