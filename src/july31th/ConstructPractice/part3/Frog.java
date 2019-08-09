package july31th.ConstructPractice.part3;

public class Frog extends Amphibian{
    Frog(){
        System.out.println("i am a Frog");
    }
    void crawl(){
        System.out.println("frog crawl");

    }
    void swim(){
        System.out.println("frog swim");
    }
    public static void main(String[] args){
        Amphibian frog = new Frog();
        frog.crawl();
        frog.swim();
    }
}
