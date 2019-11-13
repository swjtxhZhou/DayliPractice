package Chapter18th;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Directory {
    /**
     * 使用local方法产生由本地目录中的文件构成的File对象数组
     *
     * 使用了listFile（）的File.list（）的变体来产生File数组。它还使用1了FilenameFilter。若需要List而不是数组，可以是使用Arrays。asList()
     * @param dir
     * @param regex
     * @return
     */
    public static File[] local(File dir,final String regex){
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }
    public static File[] local(String path,final String regex){
        return local(new File(path),regex);
    }

    public static class TreeInfo implements Iterable<File>{
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();
        public Iterator<File> iterator(){
            return files.iterator();
        }
        void addAll(TreeInfo other){
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }
        public String toString(){
            return "dirs: "+PPrint.pformat(dirs)+"\n\nfiles: "+PPrint.pformat(files);
        }
    }

    static TreeInfo recurseDirs(File startDir,String regex){
        TreeInfo result = new TreeInfo();
        for(File item:startDir.listFiles()){
            if(item.isDirectory()){
                result.dirs.add(item);//是目录
                result.addAll(recurseDirs(item, regex));//迭代目录中的文件
            }else{
                if(item.getName().matches(regex)) result.files.add(item);//是文件
            }
        }
        return result;
    }

    public static TreeInfo walk(String start,String regex){
        return recurseDirs(new File(start),regex);
    }

    public static TreeInfo walk(File start,String regex){
        return recurseDirs(start,regex);
    }

    public static TreeInfo walk(File start){
        return recurseDirs(start,".*");
    }

    /**
     * walk方法产生给定目录下的由整个目录树中所有文件构成的list《File》（File对象比文件名更有用，File对象包含更多信息）
     *
     * walk（）方法将开始目录的名字转换为File对象，然后调用recurseDirs（），该方法递归地遍历目录，并在每次递归中收集更多的信息。
     * 为了区分普通文件和目录。返回值是一个元组--一个list持有普通文件，另一个持有目录。
     * @param start
     * @return
     */
    public static TreeInfo walk(String start){
        return recurseDirs(new File(start),".");
    }

    public static void main(String[] args){
        if(args.length == 0){
            System.out.println(".");
        }else{
            for(String arg:args){
                System.out.println(walk(arg));
            }
        }
    }
}
