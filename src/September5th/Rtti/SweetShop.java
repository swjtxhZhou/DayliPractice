package September5th.Rtti;

/**
 * 这里的每个类Candy，Gum,Cookie都有一个static子句，改子句在类第一次加载时进行
 */
public class SweetShop {
    public static void main(String[] args){
        System.out.println("inside main");
        new Candy();
        System.out.println("after creating candy");
        try{
            /**
             * 这个方法时Class类（所有Class对象都属于这个类）的一个static成员，Class对象和其他对象一样，我们可以获取和操作他的引用（也就是类加载器的工作）。
             * forName（）是取得Class对象引用的一种方法。
             * 它是用一个包含目标类的文本名（注意拼写和大小写）的String做输入参数，返回的时一个Class对象的引用，上面的代码忽略了返回值。
             * 对forName（）的调用是为了他的副作用：如果类Gum还没有加载就加载它。在加载过程中，Gum的static子句被执行。
             * 若找不到你要加载的类，会抛出异常ClassNotFoundException
             */
            Class.forName("Gum");
        }catch(ClassNotFoundException e){
            System.out.println("Couldn`t find Gum");
        }
        System.out.println("after Class.ForName(\"Gum\")");
        new Cookie();
        System.out.println("after creating cookie");
    }
}
