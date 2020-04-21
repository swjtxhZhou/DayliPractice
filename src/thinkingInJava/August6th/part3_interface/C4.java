package thinkingInJava.August6th.part3_interface;

public class C4 extends C implements I3{
    /**
     * 这里没有实现f（）方法不会报错，因为继承了C，其中有方法f（）
     * 但是这个类如果实现了f（）方法，那么就会优先使用该类的方法
     * @param args
     */
//    public int f(){
//        return 3;
//    }
    public static void main(String[] args){
        C4 c4= new C4();
        System.out.println(c4.f());
    }
}
