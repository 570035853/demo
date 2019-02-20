package singleTon;

/**
 * 内部类，如果没有调用到，是不会初始化的，所以如下这种方式，实际是JVM保证的线程安全，只有调用到的地方，才会进行初始化
 */
public class InnerClassSingleTon {

    private InnerClassSingleTon(){

    }

    static class InnerClass{
        private final static InnerClassSingleTon singleTon = new InnerClassSingleTon();
    }

    public static InnerClassSingleTon getInstance(){
        return InnerClass.singleTon;
    }
}
