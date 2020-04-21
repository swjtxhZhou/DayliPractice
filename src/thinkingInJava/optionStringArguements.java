package thinkingInJava;

public class optionStringArguements {
    static void printArgs(int required,String... args){
        System.out.println(required);
        for(String arg:args){
            System.out.println(arg);
        }
        System.out.println(" ");
    }
}
