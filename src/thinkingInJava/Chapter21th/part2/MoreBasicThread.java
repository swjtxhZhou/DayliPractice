package thinkingInJava.Chapter21th.part2;

public class MoreBasicThread {
    public static void main(String[] args){
        for(int i =0; i<5;i++){
            new Thread(new LiftOff()).start();
        }
        System.out.println("waiting for LiftOff!");
    }
}
