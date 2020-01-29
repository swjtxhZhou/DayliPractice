package August6th.processor;

/**
 * 这是策略的重要部分，是顶层的父类，需要将都会使用公共的方法设计出来
 */
class Processor {
    public String name(){
        return getClass().getSimpleName();
    }
    Object process(Object input){
        return input;
    }
}
