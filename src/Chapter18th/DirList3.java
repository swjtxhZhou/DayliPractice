package Chapter18th;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList3 {
    public static void main(String[] args){
        File path = new File(".");
        String[] list;
        if(args.length == 0){
            list = path.list();
        }else{
            /**
             * 使FileNameFilter成为list（）方法参数匿名内部类
             * 匿名内部类直接使用了args【0】，那么传递给main（）方法的参数现在就是final的
             * 这样使用优点就是解决特定问题的代码隔离，聚拢到一点。缺点是不易于阅读，需要谨慎使用
             */
            list = path.list(new FilenameFilter() {
                Pattern pattern = Pattern.compile(args[0]);
                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String dirItem:list){
            System.out.println(dirItem);
        }
    }
}
