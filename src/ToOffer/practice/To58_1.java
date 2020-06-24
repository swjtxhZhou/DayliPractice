package ToOffer.practice;

public class To58_1 {
    /**
     * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     * 考察点：字符串，字符串翻转
     * 想法
     * 1、单词本身的顺序没有改变，单词的词序顺序变化了
     * 2、先把单词的顺序也翻转，然后再把长字符串的顺序翻转
     * 3、在字符串的本身上做修改，不利用额外空间
     */
    public String ReverseSentence(String str) {
        if(str==null||str.length()==0){
            return str;
        }
        //第一步将每个单词分割出来，自己没有想出来,没有想到分割的方法（双指针）
        //一个大的循环
        int length = str.length();
        char[] chars = str.toCharArray();
        int low=0,high=0;
        while(high<=length){
            //下面这个判断在测试的时候报错了，判断顺序放反了，不然会造成数组溢出异常。
            if( high==length||str.charAt(high)==' '){
                Reverse(chars,low,high-1);
                low=high+1;//注意这里是要把已经遍历过的空格跃过去
                high++;
            }else {
                high++;
            }
        }
        //将整个字符数组全部翻转
        Reverse(chars,0,length-1);
        return new String(chars);
    }
    private void Reverse(char[] array,int low,int high){
        while(low<high){
            Swap(array,low,high);
            low++;
            high--;
        }
    }
    private void Swap(char[] array,int i,int j){
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
