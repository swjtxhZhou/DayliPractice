package August7th.part1.part3_factory_game;

import java.util.Map;

public class Chess implements Game{
    private int moves = 0;
    private static final int MOVES = 4;
    public boolean move(){
        System.out.println("Chess move"+moves);
        return ++moves != MOVES;
    }
}
