package ToOffer;

public class Sixty7th_practice {
    public int StrToInt(String str){
        if(str==null||str.length()==0)return 0;
        int result=0;
        boolean negative = false;//是否为负数
        int len = str.length();
        int i=0;
        int limit = -Integer.MAX_VALUE;//定义越界边界
        int mutiMin;//这个也是判断越界的边界，不过比limit少一位，用于将每位加上前提前判断
        if(len>0){
            //第一位可能不是数字，而是‘+’或者‘-’
            char first=str.charAt(0);
            if(first<'0'){
                if(first=='-'){
                    negative=true;
                    limit = Integer.MIN_VALUE;
                }else if(first!='+'){
                    return 0;
                }
                if(len==1){//数字不可能只是‘-’或者‘+’
                    return 0;
                }
                i++;
            }
            mutiMin = limit/10;
            while(i<len){
                int digit = str.charAt(i++)-'0';
                if(digit<0||digit>9){//不是数字
                    return 0;
                }
                //考虑越界
                if(result<mutiMin){
                    return 0;
                }
                result*=result;
                if(result-digit<limit){
                    return 0;
                }
                result-=digit;
            }
        }else{
            return 0;
        }
        return negative?result:-result;
    }

}
