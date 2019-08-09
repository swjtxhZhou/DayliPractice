package August8th.part2_nested;

public interface ClassInInterface {
    void howdy();

    /**
     * 放到接口中的任何类都自动是public和static的，因为类是static的，只是将嵌套类置于接口的命名空间内，这并不违反接口的规则。
     */
    class Test implements ClassInInterface{
        public void howdy(){
            System.out.println("SHIT");
        }
        public static void main(String[] args){
            new Test().howdy();
        }
    }
}
