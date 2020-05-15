package JavaToGod.Serializable;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ExternalizableDemo {
    //为了便于理解和节省篇幅，忽略关闭流操作及删除文件操作。真正编码时千万不要忘记
    //IOException直接抛出
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Write Obj to file
        ObjectOutputStream oos = null;
        try {oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
//            User2 user = new User2();//这是没有实现ExternalWrite与ExternalRead的类
            User3 user = new User3();
            user.setName("hollis");
            user.setAge(23);
            oos.writeObject(user);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            IOUtils.closeQuietly(oos);
        }
        //Read Obj from file
        File file = new File("tempFile");

        ObjectInputStream ois = null;
        try {ois = new ObjectInputStream(new FileInputStream(file));
//            User2 newInstance = (User2) ois.readObject();
            User3 newInstance = (User3) ois.readObject();
            //output
            System.out.println(newInstance);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            IOUtils.closeQuietly(ois);
        }
    }
}
