package thinkingInJava.Pattern.Practice10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings {
    public static void main(String[] args){
        String s = "Java now has regular expression";

        String[] strings = s.split(" ");
        for(String s1:strings){
            Pattern p = Pattern.compile("^Java");
            Matcher m = p.matcher(s1);
            while(m.find()){
                System.out.println("Match \""+m.group()+"\" at positions"+m.start()+"-"+(m.end()-1));
            }
        }
        for(String s1:strings){
            Pattern p = Pattern.compile("s*");
            Matcher m = p.matcher(s1);
            while(m.find()){
                System.out.println("Match \""+m.group()+"\" at positions"+m.start()+"-"+(m.end()-1));
            }
        }
    }
}
