package thinkingInJava.Chapter18th.part12th;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class Logon implements Serializable {
    private Date date = new Date();
    private String username ;
    /**
     * 使用transient关键字逐个字段地关闭序列化“不用麻烦你保存数据和恢复数据--我自己会处理”
     */
    private transient String password;
    public Logon(String name,String pwd){
        username = name;
        password = pwd;
    }
    public String toString(){
        return "logon info:\n  username "+username+"\n  date: "+date+"\n  password "+password;
    }
    public static void main(String[] args)throws Exception {
        Logon a = new Logon("Hulk","mylittlePony");
        System.out.println("logon a="+a);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("logon.out"));
        out.writeObject(a);
        out.close();
        TimeUnit.SECONDS.sleep(10);//延迟
        ObjectInputStream in= new ObjectInputStream(new FileInputStream("logon.out"));
        System.out.println("Recovering object at "+new Date());
        a = (Logon)in.readObject();
        /**
         * date字段被存储到磁盘并从磁盘上被恢复了出来，而且没有再重新生成
         */
        System.out.println("Logon a ="+a);
    }
}
