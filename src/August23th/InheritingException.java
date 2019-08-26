package August23th;

public class InheritingException {
    /**
     * 表示该方法可能会丢出SimpleException
     * @throws SimpleException
     */
    public void f()throws SimpleException{
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }
    public static void main(String[] args){
        InheritingException in = new InheritingException();
        try{
            in.f();
        }catch (SimpleException e){
            System.out.print("catch it");
        }
    }
}
