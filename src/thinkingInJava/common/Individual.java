package thinkingInJava.common;

public class Individual implements Comparable<Individual>{
    private static long counter = 0;
    private final long id = counter++;
    private String name;

    /**
     * 带参数构造器
     * @param name
     */
    public Individual(String name){
        this.name = name;
    }

    /**
     * 默认不带参数构造器
     */
    public Individual(){}
    public String toString(){
        return getClass().getSimpleName()+(name == null ? "":""+name);
    }

    /**
     * 访问私有成员
     * @return
     */
    public long id(){
        return id;
    }

    /**
     * 比较是否是同一个对象
     * @param o
     * @return
     */
    public boolean equals(Object o){
        return o instanceof Individual && id == ((Individual)o).id;
    }
    public int hashCode(){
        int result = 17;
        if(name!=null)
            result = 37*result+name.hashCode();
        result = 37*result+(int)id;
        return result;
    }

    /**
     * 覆盖了Comparable中的比较方法，它会产生一个排序序列，排序的规则首先按照实际类型排，如果有名字的话，
     * 按照name排序，最后按照创建的顺序排序
     * @param arg
     * @return
     */
    public int compareTo(Individual arg){
        String first = getClass().getSimpleName();
        String argFirst = arg.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        if(firstCompare!=0){
            return firstCompare;
        }
        if(name!=null && arg.name != null){
            int secondCompare = name.compareTo(arg.name);
            if(secondCompare != 0){
                return secondCompare;
            }
        }
        return (arg.id < id ? -1:(arg.id == id ? 0:1));
    }


}