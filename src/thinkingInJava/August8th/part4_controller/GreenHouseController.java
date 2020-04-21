package thinkingInJava.August8th.part4_controller;

public class GreenHouseController extends Controller{
    private boolean light = false;
    public class LightOn extends Event{
        public LightOn(long delayTime){
            super(delayTime);
        }
        public void action(){
            light = true;
        }
        public String toString(){
            return "light is on";
        }
    }
    public class LightOff extends Event{
        public LightOff(long delayTime){
            super(delayTime);
        }
        public void action(){
            light = false;
        }
        public String toString(){
            return "light is off";
        }
    }
    private boolean water = false;
    public class WaterOff extends Event{
        public WaterOff(long delayTime){
            super(delayTime);
        }
        public void action(){
            water = false;
        }
        public String toString(){
            return "water is off";
        }
    }
    public class WaterOn extends Event{
        public WaterOn(long delayTime){
            super(delayTime);
        }
        public void action(){
            water = true;
        }
        public String toString(){
            return "water is on";
        }
    }
    private String thermostat = "Day";
    public class ThermostatNight extends Event{
        public ThermostatNight(long delayTime){
            super(delayTime);
        }
        public void action(){
            thermostat = "Night";
        }
        public String toString(){
            return "thermostat on night setting";
        }
    }
    public class ThermostatDay extends Event{
        public ThermostatDay(long delayTime){
            super(delayTime);
        }
        public void action(){
            thermostat = "Day";
        }
        public String toString(){
            return "thermostat on day setting";
        }
    }
    /**
     * Bell和Restart比较特别，Bell控制响铃，然后在事件列表中增加一个Bell对象，于是过一会儿它可以再次响铃
     */
    public class Bell extends Event{
        public Bell(long delayTime){
            super(delayTime);
        }
        public void action(){
            addEvent(new Bell(delayTime));
        }
        public String toString(){
            return "Bing";
        }
    }

    /**
     * 一个由Event对象组成的数组被递交给Restart,该数组要加到控制器上。
     * 由于Restart()也是一个Event对象，所以同样可以将Restart对象添加到Restart.action中，以使系统能够有规律地来重新启动自己
     */
    public class Restart extends Event{
        private Event[] eventList;
        public Restart(long delayTime,Event[] eventList){
            super(delayTime);
            this.eventList = eventList;
            for(Event e:eventList){
                addEvent(e);
            }
        }
        public void action(){
            for(Event e:eventList){
                /**
                 * 重启动所有事件
                 */
                e.start();
                addEvent(e);
            }
            /**
             * 重启动当前事件
             */
            start();
            addEvent(this);
        }
        public String toString(){
            return "Restarting system";
        }
    }
    public static class Terminate extends Event{
        public Terminate(long delayTime){
            super(delayTime);
        }
        public void action(){System.exit(0);}
        public String toString(){
            return "Terminating";
        }
    }
}
