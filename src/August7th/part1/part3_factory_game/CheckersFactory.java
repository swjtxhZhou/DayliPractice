package August7th.part1.part3_factory_game;

public class CheckersFactory implements GameFactory{
    public Game getGame(){
        return new Checkers();
    }
}
