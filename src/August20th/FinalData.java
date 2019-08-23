package August20th;

import java.util.Random;

public class FinalData {
    private static Random rand = new Random(47);
    private String id;
    public FinalData(String id){this.id = id;}

    /**
     * value1和VALUE2都是带有编译时数值的final基本类型，所以二者都可以用作编译期常量，没有重大区别
     */
    private final int value1 = 9;
    private static final int VALUE2 = 99;
    /**
     * VALUE3定义为public则可以用于包外，定义static,强调只有一份，定义final，则说明他是一个常量
     */
    public static final int VALUE3 = 39;
    private final int i4 = rand.nextInt(20);
    static final int INT_5 = rand.nextInt(20);
    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private final static Value V_3 = new Value(33);
    private final int[] a = {1,2,3,4,5,6};
    public String toString(){
        return id+": "+"i4 = "+ i4 +"INT_5"+INT_5;
    }
    public static void main(String[] args){
        FinalData  fd1 = new FinalData("fd1");
//        fd1.value1++;定义为final,对于基本类型final使数值恒定不变
        fd1.v2.i++;//对于对象类型，final使引用恒定不变。一旦引用被初始化指向一个对象就无法把它改为指向另一个对象。然而对象其本身是可以修改的
        fd1.v1 = new Value(100);//不是final
        for(int i=0; i<fd1.a.length;i++){
            fd1.a[i]++;//对对象的引用可以改变对象本身
        }
//        fd1.v2 = new Value(0);不能改变应用的对象
//        fd1.a = new int[3];不能改变引用的对象
        System.out.print(fd1);
        System.out.print("Creating new FinalData:");
        FinalData fd2 = new FinalData("fd2");
        System.out.print(fd1);
        System.out.print(fd2);//INT_5的值不可以通过创建第二个FinalDATA对象而加以改变。因为它是static，在转载时就以初始化，而不是每次创新新对象时初始化。
    }
}
