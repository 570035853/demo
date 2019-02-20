package interview;

/**
 * Created by zoujialei on 2018/6/26.
 */
public class SingleTon {

    public static volatile SingleTon singleTon;

    private SingleTon(){}

    public static SingleTon getSingleTon() {
        if(singleTon == null){
            synchronized (SingleTon.class){
                if(singleTon == null){
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}
