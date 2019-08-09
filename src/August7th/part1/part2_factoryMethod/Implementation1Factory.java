package August7th.part1.part2_factoryMethod;

public class Implementation1Factory implements ServiceFactory{
    public Service getService(){
        return new Implementation1();
    }
}
