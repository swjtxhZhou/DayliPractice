package Chapter18th.part7th;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String> {
    /**
     * 将每行添加到StringBuffer，并且为每行加上换行符，因为在读的过程中换行符会被去除掉，接着返回一个包含整个文件的字符串
     * @param fileName
     * @return
     */
    public static String read(String fileName){
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try{
                String s;
                while((s = in.readLine())!=null){
                    sb.append(s);
                    sb.append("\n");
                }
            }finally {
                in.close();
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    /**
     * 打开文本并将其写入文件
     * 必须记得用close（）关闭文件
     * 任何打开文件的代码都要在finally子句中，作为防护措施而添加对文件的close（）调用，以保证文件将会被正确关闭。
     * @param fileName
     * @param text
     */
    public static void write (String fileName,String text){
        try{
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try{
                out.print(text);
            }finally {
                out.close();
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public TextFile(String fileName,String splitter){
        super(Arrays.asList(read(fileName).split(splitter)));//若要频繁使用这个类，我们可以重写次构造器以提高性能
        if(get(0).equals("")) remove(0);
    }
    public TextFile(String fileName){
        this(fileName,"\n");
    }
    public void write(String fileName){
        try{
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try{
                for(String item:this){
                    out.println(item);
                }
            }finally{
                out.close();
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args){
        String file = read("D:\\practie\\DayliPractice\\src\\Chapter18th\\part6th\\TextFile.java");
        write("test.txt",file);
        TextFile text = new TextFile("test.txt");
        text.write("test2.txt");
        TreeSet<String> words = new TreeSet<>(new TextFile("D:\\practie\\DayliPractice\\src\\Chapter18th\\part6th\\TextFile.java","\\W+"));
        System.out.println(words.headSet("a"));
    }
}
