package thinkingInJava.july31th.ConstructPractice.part2;

public class Chess extends BroadGame{
    Chess(){
        super(11);
        System.out.println("Chess constructed");
    }
    public static void main(String[] args){
        Chess chess =  new Chess();

    }
}
