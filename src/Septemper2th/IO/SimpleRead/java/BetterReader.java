package Septemper2th.IO.SimpleRead.java;

import java.util.Scanner;

public class BetterReader {
    public static void main(String[] args){
        /**
         * Scanner的构造器可以接受任何类型的输入对象，包括File对象、inputStream、String或者像此列中的Readable对象
         */
        Scanner stdin = new Scanner(SimpleRead.input);
        System.out.println("What is your name");
        /**
         * 有了Scanner，所有的输入、分词以及翻译的操作都隐藏在不同类型额next（）方法中。
         * 普通的next（）方法返回下一个String。
         * 所有基本类型（除了char外）都有对应的next（）方法。
         * 所有的next（）方法，只有找到一个完整的分词之后才会返回。Scanner还有相应的hasNext（）方法，用以判断下一个输入分词是否所需的类型。
         */
        String name=stdin.nextLine();
        System.out.println(name);
        System.out.println("How old are you? What is your favorite double?");
        System.out.println("(input:<age><double>)");
        int age = stdin.nextInt();
        double favorite = stdin.nextDouble();
        System.out.println(age);
        System.out.println(favorite);
        System.out.format("Hi %s,\n",name);
        System.out.format("In 5 years you will be %d.\n", age+5);
        System.out.format("My favorite double is %f,", favorite/2);
    }
}
