package Chapter17th.part2.part9th;

public class SpringDetector2 {
    public static void main(String[] args) throws Exception{
        /**
         * 重写了hashCode（），使用了number作为散列码。
         */
        SpringDetector.detectSpring(GroundDog2.class);
    }
}
