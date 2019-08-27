package August27th.ExceptionOfConstructor.TurnOffChecking;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TurnOffChecking {
    public static void main(String[] args){
        WrapCheckedException wce = new WrapCheckedException();
        /**
         * 不用try-catch模块，就可以抛出异常
         */
        wce.throwRuntimeException(3);

        for(int i= 0; i<4;i++) {
            try {
                if (i < 3)
                    wce.throwRuntimeException(i);
                else
                    throw new SomeOtherException();
            }catch (SomeOtherException e){
                System.out.println(e);
            }catch (RuntimeException re){
                try{
                    /**
                     * getClause()方法把RuntimeException(e)中的e丢出来
                     */
                    throw re.getCause();
                }catch (FileNotFoundException e){
                    System.out.println(e);
                }catch (IOException e){
                    System.out.println(e);
                }catch (Throwable e){
                    System.out.println(e);
                }
            }
        }
    }
}
