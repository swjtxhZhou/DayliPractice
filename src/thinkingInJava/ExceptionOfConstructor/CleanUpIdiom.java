package thinkingInJava.ExceptionOfConstructor;

public class CleanUpIdiom {
    public static void main(String[] args){
//        NeedsCleanUp nc1 =new NeedsCleanUp();
//        try{
//
//        }finally {
//            nc1.dispose();
//        }
//
//        NeedsCleanUp nc2 = new NeedsCleanUp();
//        NeedsCleanUp nc3 = new NeedsCleanUp();
//        try{
//
//        }finally {
//            nc2.dispose();
//            nc3.dispose();
//        }

        /**
         * 该部分创建对象时，构造器可能抛出异常的情况
         */
        try{
            NeedsCleanUp2 nc4 = new NeedsCleanUp2();
            try{
                NeedsCleanUp2 nc5 = new NeedsCleanUp2();
                try{

                }finally {
                    nc5.dispose();
                }
            }catch (ConstructorException e){
                System.out.println(e);
            }finally {
                nc4.dispose();
            }
        }catch (ConstructorException e){
            System.out.println(e);
        }catch (RuntimeException e){
            System.out.println(e);
            e.printStackTrace(System.out);
        }
    }
}
