package August7th.part1.part3_factory_game;

public class Games {
    public static void playGame(GameFactory factory){
        Game s = factory.getGame();
        while(s.move());
    }
    public static void main(String[] args){
        playGame(new CheckersFactory());
        playGame(new ChessFactory());
    }
}
