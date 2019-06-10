package interview.SingleTon;

/**
 * Created by zoujialei on 2018/6/26.
 * enum方式
 * https://blog.csdn.net/yy254117440/article/details/52305175
 *
 */
public class SingleTon {

    public static volatile SingleTon singleTon;

    private SingleTon(){
        System.out.println("init here");
    }

    public static SingleTon getSingleTon() {
        System.out.println("getSingleTon");
        if(singleTon == null){
            synchronized (SingleTon.class){
                if(singleTon == null){
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }

    public static void test(){
        System.out.println("test");
    }

    public static void main(String[] args) {
//        SingleTon.getSingleTon();
        SingleTon.test();
    }
}
