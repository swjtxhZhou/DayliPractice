package August27th.ExceptionOfConstructor;

import java.io.FileInputStream;

public class MainException {
    /**
     * 把异常传给控制台
     * 从main传递给控制台
     * @param args
     * @throws Exception
     */
    public static void main(String[] args)throws Exception{
        FileInputStream file= new FileInputStream("MainException.java");
        file.close();
    }
}
