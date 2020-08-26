package test;

public class TestTop145_8 {
    public static void main(String[] args){
        int res = myAtoi("+");
        System.out.print(res);
    }
    public static int myAtoi(String str) {
        /**
         * 思路：1、将所有的数字和正负号提取出来；2、将判断有效位置上的正负号，数字出现前的第一个；3、判断提取出来的数字是否超过有效大小（Interger。MAX_VALUE和Integer.MIN_VALUE）如果超过了返回这儿两个值，在返回位置上进行判断。
         * 上述的思想有问题，最好不要过多的将数字转换成字符串最后返回数字,考虑了过多的情况，以为会数字中会穿插各种字符。
         * 1、去掉空格；2、判断符号；3、形成整数（用res = res*10+new），
         */
        if(str==null||str.length()==0){
            return 0;
        }
        int index = 0;//遍历字符串使用的指针
        //跳过空格
        while (str.charAt(index)==' '){
            index++;
        }

        //判断正负号
        boolean isNegative = false;//默认是正整数
        if(index<str.length()&&(str.charAt(index)=='-'||str.charAt(index)=='+')){
            isNegative = str.charAt(index)=='-'?true:false;
            index++;
        }
        //判断是否到了字符串的末尾
        if(index==str.length()){
            return 0;
        }
        //找数字的同时，还需要判断是否越界
        int res = 0;
        while(index<str.length()){
            if(str.charAt(index)<'0'||str.charAt(index)>'9'){
                break;
            }
            int pop = str.charAt(index)-'0';
            if(res>(Integer.MAX_VALUE-pop)/10){//这里不使用res*10+pop，是res*10，或者+pop都可能造成溢出，
                return isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            res = res*10+pop;
            index++;//一次循环处理一位字符
        }
        return isNegative?-res:res;
    }
}
