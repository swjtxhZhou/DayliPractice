package Chapter21th.part8.restaurant2;


import Chapter19th.part1.part7.Course;
import Chapter19th.part1.part7.Food;



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
    /**
     * SynchronousQueue没有容量，是无缓冲等待队列，是一个不存储元素的阻塞队列（一个没有数据缓存的BlockingQueue），会直接将任务交给消费者，必须等队列中的添加元素被消费后才能继续添加新的元素。
     * 生产者线程对其的插入操作put必须等待消费者的移除操作take，反过来也一样。
     * 不像ArrayBlockingQueue或LinkedListBlockingQueue，SynchronousQueue内部并没有数据缓存空间，
     * 你不能调用peek()方法来看队列中是否有数据元素，
     * 因为数据元素只有当你试着取走的时候才可能存在，不取走而只想偷窥一下是不行的，
     * 当然遍历这个队列的操作也是不允许的。队列头元素是第一个排队要插入数据的线程，而不是要交换的数据。
     * 数据是在配对的生产者和消费者线程之间直接传递的，并不会将数据缓冲数据到队列中。可以这样来理解：
     * 生产者和消费者互相等待对方，握手，然后一起离开
     *
     * 每一个顾客都有一个固定的placeSetting，
     */
    private SynchronousQueue<Plate> placeSetting = new SynchronousQueue<>();
    public Customer(WaitPerson wp){waitPerson = wp;}
    public void deliver(Plate p)throws InterruptedException{
        placeSetting.put(p);//将菜品放置到对应位置上，如果上一个菜没有被消耗，那么就会怎样？？？
    }
    public void run(){
        for(Course course:Course.values()){//每一种类型的菜种随机选择一样，一共有四种
            Food food = course.randomSelection();
            try{
                waitPerson.placeOrder(this,food);//任务交到了服务员手里
                /**
                 * ？取出来的怎么知道就是这个顾客的
                 */
                println(this+" eating "+placeSetting.take());//做好了就会打印，否则会一直阻塞。
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

/**
 * 服务员和厨师只通过restaurant中的信息进行交互
 */
class WaitPerson implements Runnable{
      private static int counter = 0;
      private final int id = counter++;
      private Restaurant restaurant;
      BlockingQueue<Plate> filledOrders = new LinkedBlockingQueue<>();
      public WaitPerson(Restaurant res){restaurant = res;}
      public void placeOrder(Customer customer,Food food){
          try{
              /**
               * 创建新的订单，每个订单会有固定的顾客信息和服务员信息还有食品信息，全放在restaurant的所有订单中
               */
              restaurant.orders.put(new Order(customer,this,food));
          }catch(InterruptedException e){
              println(this+ " placeOrder interrupted");
          }
      }
      public void run(){
          try{
              while(!Thread.interrupted()){
                  Plate plate = filledOrders.take();//服务员从已经装好的菜品并带有点菜顾客的盘子的队列中，按顺序取出其中一个
                  println(this+" received "+plate+" delivering to "+plate.getOrder().getCustomer());//将盘子送到对应的客户那里去
                  plate.getOrder().getCustomer().deliver(plate);//执行送餐操作
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
                Order order = restaurant.orders.take();//orders是一个链式阻塞队列，如果没有订单会一直阻塞，先放进去的会先取出来
                Food requestedItem = order.item();//取出需要烹饪的食物
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));//模拟一段烹饪时间
                Plate plate = new Plate(order,requestedItem);//把烹饪好的事物放在盘子上，并附带有订单消息
                order.getWaitPerson().filledOrders.put(plate);//找到之前对 应的服务员，把做好的菜品放到其配送的订单队列
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
                WaitPerson waitPerson = waitPeople.get(rand.nextInt(waitPeople.size()));//会不会存在服务员人数不够的情况
                Customer c = new Customer(waitPerson);
                exec.execute(c);
                TimeUnit.MILLISECONDS.sleep(100);//每隔0.1秒就会来一位顾客
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
        Restaurant restaurant = new Restaurant(exec,5,2);//5个服务员2个厨师，一旦new了新的restaurant,就会开始运行服务员和厨师的run（）
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
