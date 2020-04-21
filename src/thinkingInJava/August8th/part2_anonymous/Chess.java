package thinkingInJava.August8th.part2_anonymous;

public class Chess implements Game{
    private Chess(){}
    private int moves = 0;
    private static final int MOVES=4;
    public boolean move(){
        System.out.println("Chess move"+moves);
        return ++moves != MOVES;
    }

    /**
     * 匿名内部类
     */
    public static GameFactory factory = new GameFactory() {
        @Override
        public Game getGame() {
            return new Chess();
        }
    };
}
