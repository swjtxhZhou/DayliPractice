package Chapter18th.part6th;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {
    public static void main(String[] args)throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("D:\\practie\\DayliPractice\\src\\Chapter18th\\part6th\\TestEOF.java")));
        /**
         * available()的工作方式会随着所读取得媒介类型的不同而有所不同
         */
        while(in.available()!=0){
            System.out.println((char)in.readByte());
        }
    }
}
