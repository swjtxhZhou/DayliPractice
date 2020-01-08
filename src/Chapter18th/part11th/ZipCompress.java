package Chapter18th.part11th;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

public class ZipCompress {
    public static void main(String[] args)throws IOException {
        FileOutputStream f = new FileOutputStream("test.gz");
        CheckedOutputStream csum= new CheckedOutputStream(f,new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);
        zos.setComment("A test of java Zipping");

        for(String arg:args){
            System.out.print("writing file "+arg);
            BufferedReader in = new BufferedReader(new FileReader(arg));
            /**
             * 每一个要加入压缩文档的文件，都必须调用putNextEntry(),并将其传递给一个ZipEntry对象
             * ZipEntry对象包含了一个功能很广泛的接口，允许你获取和设置Zip文件内特定项所有可利用的数据：名字、压缩和未压缩的文件大小、日期、CRC校验和、额外字段数据
             * 、注释、压缩方法以及他是否是一个目录入口等
             * java的Zip类库并不提供设置密码功能的支持
             */
            zos.putNextEntry(new ZipEntry(arg));
            int c;
            while ((c=in.read())!=-1) {
                out.write(c);
            }
            in.close();
            out.flush();
        }
        out.close();
        /**
         * 为了读取校验和，必须拥有与之相关联的Checksum对象的访问权限，这里保留了CheckedOutputStream和CheckedInoutStream
         */
        System.out.print("Checksum: "+csum.getChecksum().getValue());

        System.out.print("Reading file");
        FileInputStream fi= new FileInputStream("test.zip");
        CheckedInputStream csumi = new CheckedInputStream(fi,new Adler32());
        ZipInputStream in2 = new ZipInputStream(csumi);
        BufferedInputStream bis = new BufferedInputStream(in2);
        ZipEntry ze;
        /**
         * 为了能够解压缩文件，ZipInput提供了一个getNextEntry()方法返回下一个ZipEntry（存在的话），
         */
        while((ze = in2.getNextEntry())!= null){
            System.out.print("Reading file"+ze);
            int x;
            while((x=bis.read())!=-1){
                System.out.write(x);
            }
        }
        if(args.length==1){
            System.out.print("Checksum: "+csumi.getChecksum().getValue());
        }
        bis.close();
        /**
         * 解压缩有个更简便的方法利用-ZipFile对象来读取文件。该对象有一个entries（）方法用来向ZipEntries返回一个枚举
         */
        ZipFile zf = new ZipFile("test.zip");
        Enumeration e = zf.entries();
        while(e.hasMoreElements()){
            ZipEntry ze2 = (ZipEntry)e.nextElement();
            System.out.print("File: "+ze2);
        }

    }
}
