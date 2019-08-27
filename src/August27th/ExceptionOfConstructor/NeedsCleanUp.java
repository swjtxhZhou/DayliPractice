package August27th.ExceptionOfConstructor;

public class NeedsCleanUp {
    public NeedsCleanUp()throws RuntimeException{
        throw new RuntimeException();
    }
    private static int counter= 1;
    private final long id = counter++;
    public void dispose(){
        System.out.println("NeedsCleanUp"+id+"disposed");
    }
}
