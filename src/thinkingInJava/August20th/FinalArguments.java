package thinkingInJava.August20th;

public class FinalArguments {
    void with(final Gizmo g){
//        g = new Gizmo();g是final的

    }
    void without(Gizmo g){
        g = new Gizmo();
        g.spin();
    }
    void f(final int i){
//        i++;不能改变
    }
    int g(final int i){
        return i+1;
    }
}
