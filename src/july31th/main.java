package july31th;

public class main {
    public static void main(String[] args){
        CreateSimple createSimple = new CreateSimple();
        System.out.println(createSimple.simple);
        createSimple.delayedInitialization();
    }
}
