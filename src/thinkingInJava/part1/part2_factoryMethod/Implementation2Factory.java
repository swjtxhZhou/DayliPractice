package thinkingInJava.part1.part2_factoryMethod;

public class Implementation2Factory implements ServiceFactory{
    public Service getService(){
        return new Implementation2();
    }
}
