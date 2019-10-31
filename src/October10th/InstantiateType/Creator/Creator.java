package October10th.InstantiateType.Creator;

class Creator extends GenericWithCreate<X>{
    X create(){return new X();}
    void f(){
        System.out.println(element.getClass().getSimpleName());
    }
}
