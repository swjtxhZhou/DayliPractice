package Chapter21th.part8;

import static Utils.StringUtils.*;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * customer对象非常简单，只包含一个final int域。因为这些对象从来都不发生变化，因此它们是只读对象，并且不需要同步或者使用volatile。每个Teller任务在任何时刻都只从输入队列中移除一个Customer，并且在这个Customer上工作直至完成，因此Customer在任何时刻都只由一个任务访问
 */
class Customer{
    private final int serviceTime;
    public Customer(int tm){
        serviceTime = tm;
    }
    public int getServiceTime(){
        return serviceTime;
    }
    public String toString(){
        return "[ "+serviceTime+" ]";
    }
}

/**
 * CustomerLine表示顾客在等待被某个Teller服务时所排成的单一的行。这只是一个ArrayBlockingQueue，它具有一个toString（）方法，可以按照我们想要的样式打印
 */
class CustomerLine extends ArrayBlockingQueue<Customer>{
    public CustomerLine(int maxLineSize){
        super(maxLineSize);
    }
    public String toString(){
        if(this.size()==0){
            return "[ empty ]";
        }
        StringBuilder result = new StringBuilder();
        for(Customer customer:this){
            result.append(customer);
        }
        return result.toString();
    }
}

/**
 * 这个类按照随机时间间隔向这个队列中添加Customer
 */
class CustomerGenerator implements Runnable{
    private CustomerLine customers;
    private static Random rand = new Random(47);
    public CustomerGenerator(CustomerLine cq){
        customers = cq;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));//每隔一段时间增加一个新顾客，顾客排队的时间也是随机的（一秒之内）
                customers.put(new Customer(rand.nextInt(1000)));
            }
        }catch (InterruptedException e){
            println("Customer generator interrupted");
        }
        println("Customer terminating");
    }
}

/**
 * Teller从CustomerLine中取走Customer，在任何时刻他都只能处理一个顾客，并且跟踪在这个特定的班次中有他服务的Customer数量。当没有足够多的顾客时，他会被告知去执行doSomethingElse（）。而当出现了许多顾客时，他会被告知去执行serveCustomerLine（）。为了选择下一个出纳员，让其回到服务顾客的业务上，compareTo（）方法将查看出纳员服务过的数量，使得priorityQueue可以自动地将工作量最下的出纳员推向前台
 *
 */
class Teller implements Runnable,Comparable<Teller>{
    private static int counter = 0;
    private final int id = counter++;
    private int customerServed = 0;
    private CustomerLine customers;
    private boolean servingCustomerLine = true;
    public Teller(CustomerLine cq){customers = cq;}
    public void run(){
        try{
            while(!Thread.interrupted()){
                Customer customer = customers.take();
                TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
                synchronized (this){
                    customerServed++;//每服务一个顾客，计数增加
                    while(!servingCustomerLine){//如果为false，则这个teller在等待状态
                        wait();
                    }
                }
            }
        }catch (InterruptedException e){
            println(this+" interrupted");
        }
        println(this+" terminating");
    }

    /**
     *
     */
    public synchronized void doSomethingElse(){
        customerServed = 0;
        servingCustomerLine = false;
    }
    public synchronized void serveCustomerLine(){
        /**
         * 如果[boolean表达式]为true，则程序继续执行。
         * 如果为false，则程序抛出AssertionError，并终止执行
         */
        assert !servingCustomerLine:"already serving: "+this;
        servingCustomerLine = true;
        notifyAll();
    }
    public String toString(){
        return "Teller "+id+" ";
    }
    public String shortString(){
        return "T"+id;
    }
    public synchronized int compareTo(Teller other){
        return customerServed < other.customerServed ? -1 : (customerServed == other.customerServed ? 0 : 1 );
    }
}

/**
 * TellerManager是各种活动的中心，他跟踪所有的出纳员以及等待服务的顾客。他试图发现对于给定的顾客流，最优的出纳员数量是多少。在adjustTellerNumber中看到这一点，这是一个控制系统，能够以稳定的方式添加或者移除出纳员。所有的控制系统都具有稳定性问题，如果他们对变化反映过快，那么它们就是不稳定的。而如果他们反映过慢，则系统会迁移到它的某种极端情况
 */
class TellerManager implements Runnable{
    private ExecutorService exec;
    private CustomerLine customers;
    private PriorityQueue<Teller> workingTellers = new PriorityQueue<>();
    private Queue<Teller> tellersDoingOtherThings = new LinkedList<>();
    private int adjustmentPeriod;
    private static Random rand = new Random(47);
    public TellerManager(ExecutorService e,CustomerLine customers,int adjustmentPeriod){
        exec = e;
        this.customers = customers;
        this.adjustmentPeriod = adjustmentPeriod;
        Teller teller = new Teller(customers);
        exec.execute(teller);
        workingTellers.add(teller);
    }
    public void adjustTellerNumber(){
        if(customers.size()/workingTellers.size()>2){//若顾客是工作人员的两倍以上
            if(tellersDoingOtherThings.size()>0){//有空闲的teller
                /**
                 * 取出一个空闲的teller，并‘激活’他，插入到workingTellers
                 */
                Teller teller = tellersDoingOtherThings.remove();
                teller.serveCustomerLine();
                workingTellers.offer(teller);//插入
                return;
            }
            /**
             * 没有空闲的teller，则新建一个
             */
            Teller teller = new Teller(customers);
            exec.execute(teller);
            /**
             * add()和offer()都是向队列中添加一个元素。一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，调用 add() 方法就会抛出一个 unchecked 异常，而调用 offer() 方法会返回 false。因此就可以在程序中进行有效的判断！
             */
            workingTellers.add(teller);//加入
            return;
        }
        /**
         * 如果客户数量比较少，就让priorityQueue最顶部的teller去做其他事
         */
        if(workingTellers.size()>1&&customers.size()/workingTellers.size()<2){
            reassignOneTeller();
        }
        /**
         * 没有客户的情况，让所有的teller去做其他事情
         */
        if(customers.size()==0){
            while(workingTellers.size()>1){
                reassignOneTeller();
            }
        }
    }
    private void reassignOneTeller(){
        Teller teller = workingTellers.poll();
        teller.doSomethingElse();
        tellersDoingOtherThings.offer(teller);
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                adjustTellerNumber();//调整结构
                print(customers +" { ");
                for(Teller teller:workingTellers){
                    print(teller.shortString()+" ");
                }
                println(" } ");
            }
        }catch(InterruptedException e){
            println(this+" interrupted");
        }
        println(this+" terminating");
    }
    public String toString(){
        return "TellerNanager";
    }
}
public class BankTellerSimulation {
    static final int MAX_LINE_SIZE = 50;
    static final int ADJUSTMENT_PERIOD = 1000;
    public static void main(String[] args)throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        CustomerLine customers = new CustomerLine(MAX_LINE_SIZE);
        exec.execute(new CustomerGenerator(customers));
        exec.execute(new TellerManager(exec,customers,ADJUSTMENT_PERIOD));
        if(args.length>0){
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
        }else{
            println("Press Enter to quit");
            System.in.read();
        }
        exec.shutdownNow();

    }
}
