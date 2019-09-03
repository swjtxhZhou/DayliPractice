package August30th.Pattern.Strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice11 {
    public static void main(String[] args){
        Matcher m = Pattern.compile("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b").matcher("Arline ate eight apples and one orange while Anita hadn`t any");
        while(m.find()){
            System.out.println(m.group());
        }
        System.out.println();
        int i = 0;
        while(m.find(i)){
            System.out.println(m.group());
            i++;
        }
    }
}
