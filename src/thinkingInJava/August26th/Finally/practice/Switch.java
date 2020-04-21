package thinkingInJava.August26th.Finally.practice;

/**
 * finally把除内存之外的资源恢复到它们的初始状态，
 * 这种资源包括：已经打开了的文件和网络连接，甚至是外部世界的某个开关
 */
public class Switch {
    private boolean state = false;
    public boolean read(){return state;}
    public void on(){state = true;System.out.println(this);}
    public void off(){state = false;System.out.println(this);}
    public String toString(){return state?"on":"off";}
}
