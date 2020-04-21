package thinkingInJava.Chapter18th.part7th;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BinaryFile {
    /**
     * 一个重载方法接受File参数，第二个重载方法接受表示文件名的String参数
     * 这两个方法都返回byte【】数组。
     * @param bFile
     * @return
     * @throws IOException
     */
    public static byte[] read(File bFile)throws IOException{
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bFile));
        try{
            /**
             * available（）方法被用来产生恰当的数组尺寸，并且read（）方法的特定重载版本填充了这个数组0
             */
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        }finally {
            bf.close();
        }
    }
    public static byte[] read(String bFile) throws IOException{
        return read(new File(bFile).getAbsoluteFile());
    }
}
