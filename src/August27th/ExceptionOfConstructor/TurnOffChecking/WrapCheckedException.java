package August27th.ExceptionOfConstructor.TurnOffChecking;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 把“被检查的异常”包装进RuntimeException里面
 * 这样就不用吞下异常，也不必把它放到方法的异常说明里面，而异常链还能保证你不会丢失任何原始异常信息。
 */
public class WrapCheckedException {
    void throwRuntimeException(int type){
        try{
            switch(type){
                case 0:
                    throw new FileNotFoundException();
                case 1:
                    throw new IOException();
                case 2:
                    throw new RuntimeException("who am i");
                default: return;
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
