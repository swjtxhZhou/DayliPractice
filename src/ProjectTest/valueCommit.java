package ProjectTest;

public class valueCommit {

    public static void main(String[] args){
        Value value = new Value();
        value.setVal(1);
        System.out.println(value.getVal());
        changeVal(value);
        System.out.println(value.getVal());

        System.out.println((char)(2+'A'));
    }
    public static void changeVal(Value value){
        value.setVal(value.getVal()+1);
    }
}
