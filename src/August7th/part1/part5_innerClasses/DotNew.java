package August7th.part1.part5_innerClasses;

/**
 * 创建某个内部类的对象
 */
public class DotNew {
    public class Inner{
        Inner(){
            System.out.println("i am inner");
        }
    }
    public static void main(String[] args){
        DotNew dn= new DotNew();
        DotNew.Inner dni = dn.new Inner();//用.new创建内部类对象
    }
}
