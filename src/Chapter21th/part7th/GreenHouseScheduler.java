package Chapter21th.part7th;

import static Utils.StringUtils.*;

import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 每个期望得温室事件都是一个在预定事件运行运行得任务。ScheduledThreadPoolExecutor提供了解决问题得服务。通过使用schedule（运行一次任务）或者scheduleAtFixedRate（）（每隔固定的时间重复执行任务），你可以将Runnable对象设置为在将来得某个时刻执行
 *
 * volatile和synchronized在适当场合都得到了应用，以防止任务间的互相干涉，在持有DataPoint的List中的所有方法都是synchronized的，这是因为在List被创建时，使用了Collections实用工具synchronizedList（）
 */
public class GreenHouseScheduler {
    private volatile boolean light = false;
    private volatile boolean water = false;
    private String thermostat = "Day";
    public synchronized String getThermostat(){
        return thermostat;
    }
    public synchronized void setThermostat(String  thermostat){
        this.thermostat = thermostat;
    }
    ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(10);
    public  void schedule(Runnable event,long delay){
        scheduler.schedule(event,delay, TimeUnit.MILLISECONDS);
    }
    public void repeat(Runnable event,long initialDelay,long period){
        /**
         * command：执行线程
         * initialDelay：初始化延时
         * period：两次开始执行最小间隔时间
         * unit：计时单位
         */
        scheduler.scheduleAtFixedRate(event,initialDelay,period,TimeUnit.MILLISECONDS);
    }
    class LightOn implements Runnable{
        public void run(){
            println("Turning on light");
            light = true;
        }
    }
    class LightOff implements Runnable{
        public void run(){
            println("Turning off light");
            light = false;
        }
    }
    class WaterOn implements Runnable{
        public void run(){
            println("Turning on water");
            water = true;
        }
    }
    class WaterOff implements Runnable{
        public void run(){
            println("Turning off water");
            water = false;
        }
    }
    class ThermostatNight implements Runnable{
        public void run(){
            println("Themostat to nigth setting");
            setThermostat("Night");
        }
    }
    class ThermostatDay implements Runnable{
        public void run(){
            println("Themostat to day setting");
            setThermostat("Day");
        }
    }
    class Bell implements Runnable{
        public void run(){
            println("Bing!");
        }
    }
    class Terminate implements Runnable{
        public void run(){
            println("Terminating!");
            for(DataPoint dat:data) {
                println("finalDataList: " + dat);
            }
            scheduler.shutdownNow();

        }
    }

    /**
     * DataPoint持有并显示单个数据段。，而collectData是被调度的任务，它在每次运行时都可以产生仿真数据，并将其添加到GreenHouse的List《DataPoint》中
     */
    static class DataPoint{
        final Calendar time;
        final float temperate;
        final float humidity;
        public DataPoint(Calendar d,float temp,float hum){
            time = d;
            temperate = temp;
            humidity = hum;
        }
        public String toString(){
            return time.getTime()+String.format(" temperate: %1$.1f  humidity: %2$.2f", temperate, humidity);
        }
    }
    private Calendar lastTime = Calendar.getInstance();
    {
        /**
         * 只是把分钟数和秒数分别设置为30和0，其余日期和小时的都是采取当前的时间
         */
        lastTime.set(Calendar.MINUTE,30);
        lastTime.set(Calendar.SECOND,00);
    }
    private float lastTemp = 65.0f;
    private int tempDirection=+1;//用来控制温度是升还是降
    private float lastHumidity = 50.0f;
    private int humidityDirection = +1;//用来控制湿度是升还是降
    private Random rand = new Random(47);
    List<DataPoint> data = Collections.synchronizedList(new ArrayList<>());

    class CollectData implements Runnable{
        public void run(){
            println("Collecting data");
            synchronized (GreenHouseScheduler.this){
                lastTime.set(Calendar.MINUTE,lastTime.get(Calendar.MINUTE)+30);//每次是半个小时半个小时增加
                /**
                 * 这一段是仿真温度变化，总体是在温度上升
                 */
                if(rand.nextInt(5)==4){
                    tempDirection = -tempDirection;
                }
                lastTemp = lastTemp+tempDirection*(1.0f+rand.nextFloat());
                /**
                 * 这一段是仿真湿度变化，总体是在上升阶段
                 */
                if(rand.nextInt(5)==4){
                    humidityDirection = - humidityDirection;
                }
                lastHumidity = lastHumidity + humidityDirection*rand.nextFloat();
                println(new DataPoint((Calendar)lastTime.clone(),lastTemp,lastHumidity).toString());
                data.add(new DataPoint((Calendar)lastTime.clone(),lastTemp,lastHumidity));
            }
        }
    }
//    class FinalDataList implements Runnable{
//        public void run(){
//            System.out.println("finalDataList: "+data);
//        }
//    }
    public static void main(String[] args){
        GreenHouseScheduler gh = new GreenHouseScheduler();
        gh.schedule(gh.new Terminate(),5000);//schedule只执行一次，五秒触发
        gh.repeat(gh.new Bell(),0,1000);//一秒触发
        gh.repeat(gh.new ThermostatNight(),0,2000);//
        gh.repeat(gh.new LightOn(), 0,200);
        gh.repeat(gh.new LightOff(),0,400);
        gh.repeat(gh.new WaterOn(),0,600);
        gh.repeat(gh.new WaterOff(),0,800);
        gh.repeat(gh.new ThermostatDay(),0,1400);
        gh.repeat(gh.new CollectData(),500,500);//延迟0.5秒运行任务，之后每隔0.5秒运行任务
//        gh.schedule(gh.new FinalDataList(),4500);
    }
}
