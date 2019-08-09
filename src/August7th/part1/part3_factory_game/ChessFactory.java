package August7th.part1.part3_factory_game;

public class ChessFactory implements GameFactory{
    public Game getGame(){
        return new Chess();
    }
}
