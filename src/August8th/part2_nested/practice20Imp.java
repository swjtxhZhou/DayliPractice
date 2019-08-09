package August8th.part2_nested;

public class practice20Imp implements practice20{
    public void A(){
        System.out.println("outer A");
    }
    public static void main(String[] args) {
        practice20Imp outerA= new practice20Imp();
        outerA.A();
        Inner innerA = new Inner();
        innerA.A();
    }
}
