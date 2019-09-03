package Septemper2th.IO.SimpleRead.java;

import java.util.Scanner;

public class BetterReader {
    public static void main(String[] args){
        /**
         * Scanner的构造器可以接受任何类型的输入对象，包括File对象、inputStream、String或者像此列中的Readable对象
         */
        Scanner stdin = new Scanner(SimpleRead.input);
        System.out.println("What is your name");
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
