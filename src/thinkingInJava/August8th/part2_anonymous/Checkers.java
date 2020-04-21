package thinkingInJava.August8th.part2_anonymous;

public class Checkers implements Game{
    private Checkers(){}
    private int moves = 0;
    private static final int MOVES =3;
    public boolean move(){
        System.out.println("Checkers move"+moves);
        return ++moves != MOVES;
    }

    /**
     * 匿名内部类
     */
    public static GameFactory factory = new GameFactory() {
        @Override
        public Game getGame() {
            return new Checkers();
        }
    };
}
