package interview.SingleTon;

/**
 * Created by jialei.zou on 2019/5/24 .
 */
public class InnerClassSingleTon {

    private InnerClassSingleTon(){

    }
    private static class SingleTonHolder{
//        static {
//            System.out.println("static block");
//        }
        private static InnerClassSingleTon singleTon = new InnerClassSingleTon();
    }

    public static InnerClassSingleTon getInstance(){
        //如下方式，如果不调用到内部类，则不会进行内部类的初始化，
        // 外部类调用到内部类的时候，才对内部类进行了初始化
        //        return null;
        return SingleTonHolder.singleTon;

    }



}
