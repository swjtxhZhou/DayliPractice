package thinkingInJava.Chapter21th.part8.restaurant2;


import thinkingInJava.part1.part7.Course;
import thinkingInJava.part1.part7.Food;



import static Utils.StringUtils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 关于这个示例，需要观察的一项非常重要的事项，就是使用队列在任务间通信多带来的管理复杂度。这个单项技术通过反转控制极大地简化了并发编程地过程：任务没有直接地互相干涉，而是经由队列互相发送对象。接收任务将处理对象，将其当作一个消息来对待，而不是向他发送消息。若只要可能就遵循这项技术！！！
 *
 * 它引入了SynchronousQueue，这是一种没有内部容量地阻塞队列，因此每个put（）都必须等待一个take（），反之亦然。这就好像是把一个对象交给某人--没有任何桌子可以放置这个对象，因此只有这个人伸出手，准备好接收这个对象时，你才能工作。
 */

/**
 * 订单：记录了顾客，服务员和点的菜
 */
class Order{
    private static int counter = 0;
    private final Customer customer;
    private final int id = counter++;
    private final WaitPerson waitPerson;
    private final Food food;
    public Order(Customer cust,WaitPerson wp,Food f){
        customer = cust;
        waitPerson = wp;
        food = f;
    }
    public Food item(){return food;}
    public Customer getCustomer(){return customer;}
    public WaitPerson getWaitPerson(){return waitPerson;}
    public String toString(){
        return "Order: "+id+" item: "+food+" for: "+customer+" served by "+waitPerson;
    }
}

/**
 * 一个盘子中包含一个订单，和该订单上的菜
 */
class Plate{
    private final Order order;
    private final Food food;
    public Plate(Order or,Food f){
       order = or;
       food = f;
    }
    public Order getOrder(){return order;}
    public Food getFood(){return food;}
    public String toString(){return food.toString();}
}

/**
 * 顾客中包含了，服务员和顾客的位置
 */
class Customer implements Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private final WaitPerson waitPerson;
    private SynchronousQueue<Plate> placeSetting = new SynchronousQueue<>();
    public Customer(WaitPerson wp){waitPerson = wp;}
    public void deliver(Plate p)throws InterruptedException{
        placeSetting.put(p);
    }
    public void run(){
        for(Course course:Course.values()){
            Food food = course.randomSelection();
            try{
                waitPerson.placeOrder(this,food);
                println(this+" eating "+placeSetting.take());
            }catch (InterruptedException e){
                println(this+" waiting for "+course+" interrupted");
                break;
            }
        }
        println(this+" finished meal, leaving");
    }
    public String toString(){
        return "Customer "+id+" ";
    }

}
class WaitPerson implements Runnable{
      private static int counter = 0;
      private final int id = counter++;
      private Restaurant restaurant;
      BlockingQueue<Plate> filledOrders = new LinkedBlockingQueue<>();
      public WaitPerson(Restaurant res){restaurant = res;}
      public void placeOrder(Customer customer,Food food){
          try{
              restaurant.orders.put(new Order(customer,this,food));
          }catch(InterruptedException e){
              println(this+ " placeOrder interrupted");
          }
      }
      public void run(){
          try{
              while(!Thread.interrupted()){
                  Plate plate = filledOrders.take();
                  println(this+" received "+plate+" delivering to "+plate.getOrder().getCustomer());
                  plate.getOrder().getCustomer().deliver(plate);
              }
          }catch(InterruptedException e){
              println(this+" interrupted");
          }
          println(this+" off duty");
      }
      public String toString(){
          return "WaitPerson "+id+" ";
      }
}
class Chef implements Runnable{
    private static int counter =0;
    private final int id = counter++;
    private final Restaurant restaurant;
    private static Random rand = new Random(47);
    public Chef(Restaurant r){restaurant = r;}
    public void run(){
        try{
            while(!Thread.interrupted()){
                Order order = restaurant.orders.take();
                Food requestedItem = order.item();
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                Plate plate = new Plate(order,requestedItem);
                order.getWaitPerson().filledOrders.put(plate);
            }
        }catch(InterruptedException e){
            println(this+" interrupted");
        }
        println(this+ " off duty");
    }
    public String toString(){
        return "Chef "+id+" ";
    }
}
class Restaurant implements Runnable{
    private List<WaitPerson> waitPeople = new ArrayList<>();
    private List<Chef> chefs = new ArrayList<>();
    private ExecutorService exec;
    private static Random rand = new Random(47);
    BlockingQueue<Order> orders = new LinkedBlockingQueue<>();
    public Restaurant(ExecutorService e,int nWaitPerson,int nChef){
        exec = e;
        for(int i= 0;i<nWaitPerson;i++){
            WaitPerson waitPerson = new WaitPerson(this);
            waitPeople.add(waitPerson);
            exec.execute(waitPerson);
        }
        for(int i= 0;i<nChef;i++){
            Chef chef = new Chef(this);
            chefs.add(chef);
            exec.execute(chef);
        }
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                WaitPerson waitPerson = waitPeople.get(rand.nextInt(waitPeople.size()));
                Customer c = new Customer(waitPerson);
                exec.execute(c);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (InterruptedException e){
            println("restaurant interrupted");
        }
        println("restaurant closing");
    }
}

/**
 *
 */
public class RestaurantWithQueues {
    public static void main(String[] args)throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        Restaurant restaurant = new Restaurant(exec,5,2);
        exec.execute(restaurant);
        if(args.length > 0){
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
        }else{
            println("press Enter to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }

}
