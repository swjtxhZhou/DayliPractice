package thinkingInJava.july31th.ConstructPractice.part2;

public class BroadGame extends Game{
    BroadGame(int i){
        super(i);//调用Game的构造器
        System.out.println("BroadGame constructed");
    }
}
