package Chapter18th.part11th;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPcompres {
    public static void main(String[] args)throws IOException {
        /**
         * 压缩类库是按字节方式而不是按字符方式处理的
         * 这些类不是从Reader和Writer继承来的，而是InputStream和OutputStream继承结构的一部分
         * 我们可以混用两种类型的数据流（）InputStreamReader和OutputStreamWriter
         */
        if(args.length == 0){
            System.out.println("Usage: \n GZIPcompress file\n"+"\tUses GZIP compression to compress "+"the file to test.gz");
            System.exit(1);
        }
        /**
         * GZIP接口比较简单，若只想对单个数据流（不是一系列互异数据）进行压缩，那么他可能是比较合适的选择
         */
        BufferedReader in  = new BufferedReader(new FileReader(args[0]));

        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));
        System.out.println("Writing file");
        int c;
        while((c=in.read())!=-1){
            out.write(c);
        }
        in.close();
        out.close();
        System.out.println("Reading file");
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
        String s;
        while((s=in2.readLine())!=null){
            System.out.println(s);
        }
    }
}
