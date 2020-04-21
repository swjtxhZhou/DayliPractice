package thinkingInJava.july31th;

public class CreateSimple {
    Simple simple;
    public void delayedInitialization(){
        if (simple == null){
            simple = new Simple("you are simple");
        }
    }
}
