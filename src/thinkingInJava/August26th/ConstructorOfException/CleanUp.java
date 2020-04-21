package thinkingInJava.August26th.ConstructorOfException;

/**
 * 清理惯用法，在创建需要清理的对象后，立即进入一个try——catch模块
 */
public class CleanUp {
    public static void main(String[] args){
        try{
            /**
             * 对于在构造阶段可能会抛出异常，并且要求清理的类，最安全的使用方式是嵌套的try子句
             * 若构造成功，能确保在finally中执行清理操作
             * 若构造失败将进入外部的catch子句，不会调用dispose（）子句把
             */
            InputFile in = new InputFile("CleanUp.class");
            try{
                String s;
                int i =1;
                while( (s=in.getLine()) != null)i++;
                System.out.println("i:"+i);
            }catch (Exception e){
                System.out.println("caught Exception in main");
                e.printStackTrace(System.out);
            }finally {
                in.dispose();
            }
        }catch (Exception e){
            System.out.println("InputFile constructor failed");

        }

    }
}
