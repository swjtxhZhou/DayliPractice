package Chapter18th;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
    public static void main(String[] args){
        File path = new File(".");
        String[] list;
        if(args.length == 0){
            list = path.list();
        }else{
            list = path.list(new DirFilter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);//按字母顺序排序
        for(String dirItem:list){
            System.out.println(dirItem);
        }
    }
}
class DirFilter implements FilenameFilter{
    private Pattern pattern;
    public DirFilter(String regex){
        pattern = Pattern.compile(regex);
    }

    /**
     * 这个类存在的原因就是实现accept方法。并把这个accept方法提供给list（）使用，是list（）可以回调accept（），
     * 进而决定哪些文件包含在列表中。
     * 这种结构称为回调，这是一个策略模式，因为list（）实现了基本的功能，而且按照FileNameFilter的形式提供了这个策略，一边完善list（）再提供服务是所需的算法。
     * 因为list（）接受FileNameFilter对象作为参数，这意味着我们可以传递实现了FileNameFilter接口的任何类的对象。
     * 策略的目的就是提供了代码行为灵活性
     * accept方法必须接受一个代表某个特定文件的所在目录的file对象，以及包含了那个文件名的一个String。
     * list（）方法会为此目录对象下的每个文件名调用accept（），来判断该文件是否包含在内
     *
     * @param dir
     * @param name
     * @return
     */
    public boolean accept(File dir,String name){
        return pattern.matcher(name).matches();
    }
}
