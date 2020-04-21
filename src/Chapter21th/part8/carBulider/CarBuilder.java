package Chapter21th.part8.carBulider;
import static Utils.StringUtils.*;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

class Car{
    private final int id;
    private boolean
            engine = false,
            driveTrain = false,
            wheels = false;
    public Car(int id){this.id = id;}
    public synchronized int getId(){return id;}
    public synchronized void addEngine(){engine = true;}
    public synchronized void addDriveTrain(){driveTrain = true;}
    public synchronized void addWheels(){wheels = true;}
    public synchronized String toString(){
        return "Car "+id+" ["+" engine: "+engine+" drivenTrain: "+driveTrain+" Wheels: "+wheels+" ] ";
    }
}
class CarQueue extends LinkedBlockingQueue<Car> {
}
class ChassisBuilder implements Runnable{//制造底盘
    private CarQueue carQueue;
    private int counter = 0;
    public ChassisBuilder(CarQueue cq){carQueue = cq;}//传入一个链式队列
    public void run(){
        try{
            while(!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(500);
                Car c = new Car(counter++);//底盘是第一步。所以在这里创建汽车
                println("ChassisBuilder created "+c);
                carQueue.put(c);//新创建的汽车底盘放进链式队列
            }
        }catch (InterruptedException e){
            println("Interrupted: ChassisBuilder");
        }
        println("ChassisBuilder off");
    }
}

/**
 * Assembler从一个CarQueue中取走Car，并雇请robot对其加工。CyclicBarrier使Assembler等待，直至所有的Robot都完成，并且在那一时刻它会将car放置到即将离开它的CarQueue中，然后被传送到下一个操作。
 */
class Assembler implements Runnable{
    private CarQueue chassisQueue, finishingQueue;
    private Car car;
    private CyclicBarrier barrier = new CyclicBarrier(4);//循环栅栏
    private RobotPool robotPool;
    public Assembler(CarQueue cq,CarQueue fq,RobotPool robotPool){
        chassisQueue = cq;
        finishingQueue = fq;
        this.robotPool = robotPool;
    }
    public Car car(){return car;}
    public CyclicBarrier barrier(){return barrier;}
    public void run(){//？？？
        try{
            while(!Thread.interrupted()){
                car = chassisQueue.take();//从底盘安装好的汽车队列中取出第一辆车
                /**
                 * 每一个hire方法里面都有递归，除非能在for循环中直接正常退出
                 */
                robotPool.hire(EngineRobot.class,this);//启动装引擎机器人
                robotPool.hire(DriveTrainRobot.class,this);//启动装传动系统机器人
                robotPool.hire(WheelRobot.class,this);//启动装轮胎机器人
                barrier.await();//这个方法要调用四次才会继续下一步
                finishingQueue.put(car);//把车放进装配好的队列
            }
        }catch (InterruptedException e){
            println("Exiting Assembler via interrupt");
        }catch (BrokenBarrierException e){
            throw new RuntimeException(e);
        }
        println("Assembler off");
    }
}

/**
 * 最终的CarQueue的消费者是一个Reporter对象，它只是打印Car，以显示所有的任务都已经正确完成
 */
class Reporter implements Runnable{
    private CarQueue carQueue;
    public Reporter(CarQueue cq){carQueue = cq;}
    public void run(){
        try{
            while(!Thread.interrupted()){
                println(carQueue.take().toString());
            }
        }catch (InterruptedException e){
            println("Exiting Reporter via interrupt");
        }
        println("Reporter off");
    }
}
abstract class Robot implements Runnable{
    private RobotPool pool;
    public Robot(RobotPool robotPool){pool = robotPool;}
    protected Assembler assembler;
    public Robot assignAssembler(Assembler assembler){//分配安装线？
        this.assembler = assembler;
        return this;
    }
    private boolean engage = false;
    public synchronized void engage(){
        engage = true;
        notifyAll();
    }
    abstract protected void performService();
    public void run(){
        try{
            powerDown();
            while(!Thread.interrupted()){
                performService();
                assembler.barrier().await();
                powerDown();
            }
        }catch (InterruptedException e){
            println("Exiting "+this+" via interrupt");
        }catch(BrokenBarrierException e){
            throw new RuntimeException(e);
        }
        println(this+" off");
    }
    private synchronized void powerDown()throws InterruptedException{
        engage = false;
        assembler = null;
        pool.release(this);
        while(engage == false){
            wait();
        }
    }
    public String toString(){
        return getClass().getName();
    }
}
class EngineRobot extends Robot{
    public EngineRobot(RobotPool robotPool){super(robotPool);}
    protected void performService(){
        println(this+" installing engine");
        assembler.car().addEngine();
    }
}
class DriveTrainRobot extends Robot{
    public DriveTrainRobot(RobotPool robotPool){super(robotPool);}
    protected void performService(){
        println(this+" installing driveTrain");
        assembler.car().addDriveTrain();
    }
}
class WheelRobot extends Robot{
    public WheelRobot(RobotPool robotPool){super(robotPool);}
    protected void performService(){
        println(this+" installing wheels");
        assembler.car().addWheels();
    }
}

/**
 * robot是在池中管理的，当需要完成工作时，就会从池中雇请适当的robot，在工作完成时，这个robot会返回到池中
 */
class RobotPool{
    private Set<Robot> pool = new HashSet<>();
    public synchronized void release(Robot robot) {
        add(robot);
    }
    private synchronized void add(Robot robot) {
        pool.add(robot);
        notifyAll();
    }
    public synchronized void hire(Class<? extends Robot> robotType,Assembler assembler)throws InterruptedException{

        for(Robot robot:pool){
            if(robot.getClass().equals(robotType)){//选取对应的机器人
                pool.remove(robot);//把该类型机器人移除池中，表示正在使用
                robot.assignAssembler(assembler);//？？？
                robot.engage();
                return;
            }
        }
        /**
         *
         */
        wait();//调用这个对象的锁 将这个方法阻塞，除非正在调用的方法结束
        hire(robotType,assembler);//循环调用
    }
}

/**
 * 每辆car都从创建地盘开始，紧跟着是安装发动机，车厢和轮子
 */
public class CarBuilder {
    public static void main(String[] args)throws Exception{
        CarQueue chassisQueue = new CarQueue(),
                finishingQueue = new CarQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        RobotPool robotPool = new RobotPool();

        exec.execute(new EngineRobot(robotPool));
        exec.execute(new DriveTrainRobot(robotPool));
        exec.execute(new WheelRobot(robotPool));
        exec.execute(new Assembler(chassisQueue,finishingQueue,robotPool));//assembler只创建了一个                                                                                                                                                                                                       
        exec.execute(new Reporter(finishingQueue));
        exec.execute(new ChassisBuilder(chassisQueue));
        TimeUnit.SECONDS.sleep(7);
        exec.shutdownNow();
    }
}
