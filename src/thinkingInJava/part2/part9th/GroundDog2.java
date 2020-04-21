package thinkingInJava.part2.part9th;

public class GroundDog2 extends GroundDog{
    public GroundDog2(int n){super(n);}
    public int hashCode(){return number;}
    public boolean equals(Object o){
        return o instanceof GroundDog2 && (number ==((GroundDog2) o).number);
    }
}
