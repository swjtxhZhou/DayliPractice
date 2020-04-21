package thinkingInJava.ExceptionOfConstructor.ConstructorHierarchies;

public class Human {
    /**
     * 异常处理系统会按照代码书写顺序找出“最近”的处理程序
     * 找到匹配处理程序后，就不再继续查找
     * 查找的时候不要求抛出的异常同处理程序所声明的异常完全匹配。派生类也能匹配其基类的处理程序
     * @param args
     */
    public static void main(String[] args){
        try{
            throw new Sneeze();
        }catch(Sneeze e){
            System.out.println(e);
        }catch(Annoyance e){
            System.out.println(e);
        }

        try{
            throw new Sneeze();
        }catch (Annoyance e){
            System.out.println(e);
        }
    }
}
