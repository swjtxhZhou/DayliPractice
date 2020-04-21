package thinkingInJava.October10th;

import thinkingInJava.October9th.Generator.Generator;

/**
 * 只有private的构造器，强制使用Generator对象
 */
public class Customer {
    private static long counter = 1;
    private final long id= counter++;
    private Customer(){}
    public String toString(){
        return "Customer "+id;
    }
    public static Generator<Customer> generator(){
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}
