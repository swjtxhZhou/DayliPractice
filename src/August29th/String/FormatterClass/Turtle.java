package August29th.String.FormatterClass;

import java.io.PrintStream;
import java.util.Formatter;

public class Turtle {
    private String name;
    private Formatter f;
    public Turtle(String name,Formatter f){
        this.name = name;
        this.f = f;
    }
    public void move(int x,int y){
        f.format("%s The turtle is at(%d,%d)\n",name,x,y);
    }
    public static void main(String[] args){
        PrintStream outAlias = System.out;
        /**
         * Formatter的构造器经过重载可以接受多种输出目的地，不过最常用的还是PrintSream（）、OutputStream()、和File
         */
        Turtle tommy = new Turtle("tommy",new Formatter(System.out));
        Turtle terry = new Turtle("terry",new Formatter(outAlias));
        tommy.move(0,0);
        terry.move(4,8);
        tommy.move(3,4);
        terry.move(2,5);
    }
}
