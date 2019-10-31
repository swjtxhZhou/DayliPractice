package October10th;

import October9th.Generator.Generator;

/**
 * 构造器是private的，强制必须使用Generator对象
 */
public class Teller {
    private static long counter =1;
    private final long id = counter++;
    private Teller(){}
    public String toString(){
        return "Teller "+id;
    }
    public static Generator<Teller> generator = new Generator<Teller>(){
        public Teller next(){
            return new Teller();
        }
    };
}
