package thinkingInJava.Pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Resetting {
    public static void main(String[] args){
        Matcher m= Pattern.compile("[frb][aiu][gx]").matcher("fix the rug with bags");
        while(m.find()){
            System.out.println(m.group()+" ");
        }
        System.out.println();
        /**
         * 通过reset（）方法，可以将现有的Matcher对象应用于一个新的字符序列
         */
        m.reset("fix the rig with rags");
        while(m.find()){
            System.out.println(m.group()+" ");
        }
        m.reset();
        while(m.find()){
            System.out.println(m.group()+" ");
        }
    }
}
