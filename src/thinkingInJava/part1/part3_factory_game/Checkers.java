package thinkingInJava.part1.part3_factory_game;

public class Checkers implements Game{
    private int moves = 0;
    private static final int MOVES = 3;
    public boolean move(){
        System.out.println("checkers move"+moves);
        return ++moves != MOVES;
    }
}
