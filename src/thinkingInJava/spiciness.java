package thinkingInJava;

/**
 * 创建enum时，编译器会自动添加一些有用的特性。它会创建toString()方法，ordinal()方法，static values()方法
 */
public enum  spiciness {
    NOT,MILD,MEDIUM,HOT,FLAMING//枚举类型的实例是常量，按照命名管例都用大写字母表示（一个名字有多个单词用下划线隔开）
}
