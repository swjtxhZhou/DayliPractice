package Chapter19th.part1.part5;

import October9th.Generator.Generator;

import java.util.Random;

/**
 * 创建一个新的enum时，可以实现一个或者多个接口
 */
enum CartoonCharacter implements Generator<CartoonCharacter> {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
    private Random random = new Random(47);
    public CartoonCharacter next(){
        return values()[random.nextInt(values().length)];
    }
}

public class EnumImplementation{
    public static <T> void printNextGenerator(Generator<T> rg){
        System.out.print(rg.next()+", ");
    }
    public static void main(String[] args){
        /**
         * 必须使用一个enum实列才能调用printNextGenerator（）方法
         */
        CartoonCharacter cc = CartoonCharacter.BOB;
        for(int i=0;i<10;i++){
            printNextGenerator(cc);
        }
    }
}
