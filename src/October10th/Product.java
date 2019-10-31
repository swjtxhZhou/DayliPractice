package October10th;

import October9th.Generator.Generator;

import java.util.Random;

public class Product {
    private final int id;
    private String description;
    private double price;
    public Product(int IDNumber,String descr,double price){
        id = IDNumber;
        description = descr;
        this.price = price;
        System.out.println(toString());
    }
    public String toString(){
        return id+": "+description+", price:$"+price;
    }
    public void priceChange(double change){
        price +=change;
    }
    public static Generator<Product> generator = new Generator<Product>() {
        private Random rand = new Random(47);
        @Override
        public Product next() {
            return new Product(rand.nextInt(1000), "Test",Math.round(rand.nextDouble()*1000.0+0.99));//round() 方法可把一个数字舍入为最接近的整数。
        }
    };
}
