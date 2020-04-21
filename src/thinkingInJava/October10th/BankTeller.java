package thinkingInJava.October10th;

import java.util.*;

public class BankTeller {
    public static void server(Teller t,Customer c){
        System.out.println(t + " servers "+c);
    }
    public static void main(String[] args){
        Random rand = new Random(47);
        Queue<Customer> line = new LinkedList<>();
        Generators.fill(line,Customer.generator(),15);
        List<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers,Teller.generator,4);
        for(Customer c :line){
            server(tellers.get(rand.nextInt(tellers.size())),c);
        }
    }
}
