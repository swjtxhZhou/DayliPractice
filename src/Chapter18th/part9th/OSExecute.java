package Chapter18th.part9th;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 对于经常需要在java内部执行其他操作系统的程序，并且要控制这些程序的输入和输出，java类提供了这些操作的类
 */
public class OSExecute {
    public static void command(String command){
        boolean err = false;
        try{
            /**
             * 要想运行一个程序，需要想OSExecute.command()传递一个command字符串，他与你在控制台运行该程序所键入的命令相同。
             * 这个命令传递给java.lang.ProcessBuilder构造器（它要求这个命令作为一个String对象序列而被传递），然后产生ProcessBuilder对象被启动
             */
            Process process=new ProcessBuilder(command.split(" ")).start();
            /**
             * 为了捕获程序执行是产生的标准输出流，需要调用getInputStream（），这是因为InputStream是我们可以从中读取信息的流
             */
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while((s=results.readLine())!=null){
                System.out.println(s);
            }
            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while((s=errors.readLine())!=null){
                System.err.println(s);
                err = true;
            }
        }catch (Exception e){
            if(!command.startsWith("CMD /C")) command("CMD /C"+command);
            else throw new RuntimeException(e);
        }
        if(err){
            throw new OSExecuteException("ERRORS EXECUTING"+command);
        }
    }
}
