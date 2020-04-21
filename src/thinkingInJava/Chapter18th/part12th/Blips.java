package thinkingInJava.Chapter18th.part12th;

import java.io.*;

public class Blips {
    public static void main(String[] args)throws IOException,ClassNotFoundException{
        System.out.println("Constructing Objects");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blips.out"));
        System.out.println("Saving objects");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
        System.out.println("Recovering b1");
        b1 = (Blip1)in.readObject();
        System.out.println("Recovering b2");
        /**
         * 恢复Blip2会抛出异常。因为Blip2的构造器不是公共的
         * 恢复b1，会调用Blip1默认构造器。对于Serialization对象，对象完全以他存储的二进制位为基础来构造，而不调用构造器。
         * 对于一个Externalization对象，所有普通的默认构造器都会被调用，然后调用readExternal（）--所有的默认构造器都会被调用，才能使Externalization对象产生正确的行为
         */
        b2 = (Blip2)in.readObject();
    }
}
class Blip1 implements Externalizable{
    public Blip1(){
        System.out.println("Blip1 Constructor");
    }
    public void writeExternal(ObjectOutput out)throws IOException {
        System.out.println("Blip1.writeExternal");
    }
    public void readExternal(ObjectInput in)throws IOException,ClassNotFoundException{
        System.out.println("Blip1.readExternal");
    }
}
class Blip2 implements Externalizable{
    Blip2(){
        System.out.println("Blip2 Constructor");
    }
    public void writeExternal(ObjectOutput out)throws IOException{
        System.out.println("Blip2.writeExternal");
    }
    public void readExternal(ObjectInput in)throws IOException,ClassNotFoundException{
        System.out.println("Blip2.readExternal");
    }

}
