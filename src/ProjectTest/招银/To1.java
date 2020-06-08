package ProjectTest.招银;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class To1 {
    public static void main(String[] args) {
        try {
//            InputStreamReader isr = new InputStreamReader(System.in);
//            BufferedReader br = new BufferedReader(isr);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str1 = br.readLine();
            String str2 = br.readLine();
            Integer num1 = Integer.parseInt(str1);
            Integer num2 = Integer.parseInt(str2);
            System.out.println(num1+num2);

        }catch(Exception e){

        }
    }
}
