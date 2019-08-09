package August8th.part2_anonymous;

public class Games {
    public static void playGame(GameFactory gameFactory){
        Game s=gameFactory.getGame();
        while(s.move());
    }
    public static void main(String[] args){
        playGame(Chess.factory);
        playGame(Checkers.factory);
    }
}
