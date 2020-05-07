package JavaToGod;

public class KonwConcat {
    public static void main(String[] args){
        String s = "abc";
        s.concat("de");//这样并不会改变s应用的字符串，即原始字符串不会改变，调用这个方法需要一个引用来接收这个方法返回的新字符串
        System.out.println(s);
/**
 * 第三行和第四行没有任何区别，因为String.valueOf(i)也是调用Integer.toString(i)来实现的。
 *
 * 第二行代码其实是String i1 = (new StringBuilder()).append(i).toString();，首先创建一个StringBuilder对象，然后再调用append方法，再调用toString方法。
 */
        int i = 5;
        String i1 = "" + i;
        String i2 = String.valueOf(i);
        String i3 = Integer.toString(i);
    }



}
