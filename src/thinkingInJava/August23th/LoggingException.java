package thinkingInJava.August23th;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * 异常与记录日志
 */
public class LoggingException extends Exception{
    /**
     * 创建了一个String参数相关联的Logger对象（通常与错误相关的包名和类名，这里是类名）
     * 这个Logger对象会将其输出发送到System.err
     */
    private static Logger logger = Logger.getLogger("LoggingException");
    public LoggingException(){
        StringWriter trace = new StringWriter();
        /**
         * printStackTrace(）方法不会默认的产生字符串。为了获得字符串，我们需要使用重载的printStackTrace()，他接受一个PrintWriter对象作为参数
         * 将一个StringWriter对象传递给这个PrintWriter构造器，通过调用toString（）方法，就可以将输出抽取为一个String
         */
        printStackTrace(new PrintWriter(trace));
        /**
         * 向Logger写入的最简单方式就是调用与日志记录消息的级别相关联的方法，这里使用的是severe（）。为了产生日志消息我们要获取异常抛出处的栈轨迹
         */
        logger.severe(trace.toString());
    }
}

