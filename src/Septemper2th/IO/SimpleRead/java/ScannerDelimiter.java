package Septemper2th.IO.SimpleRead.java;

import java.util.Scanner;

public class ScannerDelimiter {
    public static void main(String[] args){
        Scanner scanner = new Scanner("12,42,78,99,42");
        /**
         * 这个例子使用逗号（包括逗号前后任意的空白字符）作为界定符，同样的技术也可以读取用逗号分隔的文件
         * 我们可以使用useDelimiter（）来设置定界符，同时，还有一个delimiter（）方法，返回当前正在作为定界符使用的pattern对象
         */
        scanner.useDelimiter("\\s*,\\s*");
        while(scanner.hasNextInt()){
            System.out.println(scanner.nextInt());
        }
        System.out.println(scanner.delimiter());
    }
}
