package thinkingInJava.August8th.part4_controller;



public class TestController {
    public static void main(String[] args){
        GreenHouseController gc = new GreenHouseController();
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1000)
        };
        gc.addEvent(gc.new Restart(2000,eventList));
        if(args.length == 1){
            gc.addEvent(new GreenHouseController.Terminate(new Integer(args[0])));
        }
        gc.run();
    }
}
