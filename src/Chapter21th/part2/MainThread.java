package Chapter21th.part2;

public class MainThread {
    public static void main(String[] args){
        LiftOff liftOff = new LiftOff();
        /**
         * 这里也是用了线程，即总是分配给main（）的那个线程
         */
        liftOff.run();
    }
}
