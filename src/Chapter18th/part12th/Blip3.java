package Chapter18th.part12th;

import java.io.*;

/**
 * 若从一个Externalization对象继承，通常需要调用基类版本的writeExtenal（）和readExtenal（）来为基类组件提供恰当的存储和恢复功能
 */
public class Blip3 implements Externalizable{
    private int i;
    private String s;
    public Blip3() {
        System.out.println("Blip3 constructor");
    }
    public Blip3(String x,int a){
        System.out.println("Blip3(String x,int a)");
        s =x;//s,i的初始化只在非默认构造器
        i =a;
    }
    public String toString(){
        return s+i;
    }

    /**
     * 我们需要在writeExtenal（）方法中将来自对象的重要信息写入。还必须在readExternal中恢复数据
     * @param out
     * @throws IOException
     */
    public void writeExternal(ObjectOutput out)throws IOException {
        System.out.println("Blip3.writeExternal");
        out.writeObject(s);
        out.writeInt(i);
    }

    /**
     * 字段s和i只在第二个构造器中初始化，而不是再默认的构造器中初始化
     * 意味者不在readExternal（）中初始化s和i，s就会为null，而i就会为零
     * @param in
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void readExternal(ObjectInput in)throws IOException,ClassNotFoundException{
        System.out.println("Blip3.readExternal");
        s = (String)in.readObject();
        i = in.readInt();
    }
    public static void main(String[] args)throws IOException, ClassNotFoundException{
        System.out.println("Constructing objects");
        Blip3 b3 = new Blip3("A string",47);
        System.out.println(b3);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Blip3.out"));
        System.out.println("Saving Blip3");
        out.writeObject(b3);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip3.out"));
        System.out.println("Recovering Blip3");
        /**
         *
         */
        b3 = (Blip3)in.readObject();
        System.out.println(b3);
    }

}
