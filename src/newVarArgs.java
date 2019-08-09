public class newVarArgs {//可变参数列表
    static void printArgs(Object... args){
        for(Object arg:args){
            System.out.println(arg);
        }
        System.out.println(" ");
    }
}
