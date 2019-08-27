package August26th.ConstructorOfException;

import java.io.*;

public class InputFile {
    private BufferedReader in;
    public InputFile(String fname){
        try{
            /**
             * FileReader对象本身用处不大，但可以用它来简历BufferedReader对象
             */
            in = new BufferedReader(new FileReader(fname));
        }catch(FileNotFoundException e){
            /**
             * 捕获到该异常不需要关闭文件，因为文件还没打开
             */
            System.out.println("Could not open"+fname);
//            throw e;
        }catch (Exception e){
            try{
                /**
                 * close()方法也可能抛出异常
                 */
                in.close();
            }catch (IOException e2){
                System.out.println("in.close() successful");
            }
            throw e;
        }finally {

        }
    }

    /**
     * 该方法会返回表示文件下一行内容的字符串
     * @return
     */
    public String getLine(){
        String s;
        try{
            s = in.readLine();
        }catch(IOException e){
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }

    /**
     * 用户不使用InputFile对象必须调用该方法，
     * 这将释放BufferedReader和FileReader对象所占用的资源
     *
     */
    public void dispose(){
        try{
            in.close();
            System.out.println("dispose() successful");
        }catch (IOException e2){
            throw new RuntimeException("in.close() failed");
        }
    }
}
