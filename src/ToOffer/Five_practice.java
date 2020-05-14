package ToOffer;

public class Five_practice {
    /**
     * 将一个字符串中的空格替换成 "%20"
     * ① 在字符串尾部填充任意字符，使得字符串的长度等于替换之后的长度。因为一个空格要替换成三个字符（%20），所以当遍历到一个空格时，需要在尾部填充两个任意字符。
     *
     * ② 令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。P1 和 P2 从后向前遍历，当 P1 遍历到一个空格时，就需要令 P2 指向的位置依次填充 02%（注意是逆序的），否则就填充上 P1 指向字符的值。从后向前遍是为了在改变 P2 所指向的内容时，不会影响到 P1 遍历原来字符串的内容。
     *
     * ③ 当 P2 遇到 P1 时（P2 <= P1），或者遍历结束（P1 < 0），退出。
     *
     * 自己的理解：先计算有多少个空格，将其添加到末尾，然后用两个指针分别从后向前移动，一个在原始String的末尾一个在添加了空格的String的末尾。分别向前移动，若遇到空格，第二个指针分别把从后往前的三个字符替换目标字符，第一个指针继续向前，若遇到的是字符，则把字符放到字符串末尾，两个指针继续向前。
     */
    public String ReplaceSpace(StringBuffer str){
        //记录空格的数量
        int numOfSpace = 0;
        int orignalIndex = str.length()-1;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                str.append("  ");//在末尾添加两个字符
            }
        }
        //准备两个指针，一个指向添加了空格的字符串的末尾，一个指向原来字符串的末尾
        int Index = str.length()-1;
        while(orignalIndex>=0&&orignalIndex<=Index){
            //原始字符串遇到空格，用%20分别替换
            char c = str.charAt(orignalIndex--);
            if(c==' '){
                str.setCharAt(Index--,'0');
                str.setCharAt(Index--,'2');
                str.setCharAt(Index--,'%');
            }else if(c!=' '){
                //遇到了字符把它放在后面
                str.setCharAt(Index--,c);
            }
        }
        return str.toString();
    }
}
