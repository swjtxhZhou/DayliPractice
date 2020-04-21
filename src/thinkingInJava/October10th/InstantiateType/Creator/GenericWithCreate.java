package thinkingInJava.October10th.InstantiateType.Creator;

abstract class GenericWithCreate<T> {
    final T element;
    GenericWithCreate(){
        element = create();
    }
    abstract T create();//模板方法设计模式。get()是模板，create（）是在子类中定义的，用来产生子类类型的对象。
}
