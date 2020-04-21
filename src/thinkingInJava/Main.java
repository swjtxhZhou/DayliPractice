package thinkingInJava;

public class Main {

    public static void main(String[] args) {
//        thinkingInJava.varAras.printArgs(new Object[]{new Integer(1),new Integer(2),new Integer(3),});//数组对象的初始化形式
//        thinkingInJava.varAras.printArgs(new Object[]{"one", "two", "Three",});
//        thinkingInJava.varAras.printArgs(new Object[]{new thinkingInJava.A(),new thinkingInJava.A(), new thinkingInJava.A()});
//        thinkingInJava.newVarArgs.printArgs(new Integer(47),new Float(3.14),new String("haha"));//都成为了Object对象
        optionStringArguements.printArgs(1,"one","two","Three");//后面可变参数必须是String对象
        spiciness howHot= spiciness.HOT;
        System.out.println(howHot);
        for(spiciness s: spiciness.values()){
            System.out.println(s+"ordinal:"+s.ordinal());
        }
    }
}
