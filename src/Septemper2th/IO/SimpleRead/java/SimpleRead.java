package Septemper2th.IO.SimpleRead.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class SimpleRead {
    /**
     * StringReader将String转换成可以读取的流对象，然后用这个对象构造BufferedReader对象
     * 因为要使用BufferedReader的readLine方法。
     *
     */
    public static BufferedReader input = new BufferedReader(new StringReader("Sir Robin of Camelot\n22 1.61803"));
    public static void main(String[] args){
        try{
            System.out.println("What is your name?");
            /**
             * 利用input对象一次读取一行。
             * readLine（）方法将一行输入转为String对象。
             *
             */
            String name = input.readLine();
            System.out.println("How old are you?What is your favorite doubble?");
            System.out.println("(input:<age><double>)");
            String numbers = input.readLine();
            System.out.println(numbers);
            String[] numArray = numbers.split(" ");
            int age = Integer.parseInt(numArray[0]);
            double favorite = Double.parseDouble(numArray[1]);
            System.out.format("Hi %s.\n",name);
            System.out.format("In 5 years you will be %d.\n",age+5);
            System.out.format("My favorite double is %f.",favorite/2);
        }catch(IOException e){
            System.err.println("I/O exception");
        }
    }
}
