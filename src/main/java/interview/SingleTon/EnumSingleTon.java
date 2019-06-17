package interview.SingleTon;

/**
 * Created by jialei.zou on 2019/6/11 .
 */
public class EnumSingleTon {

    private EnumSingleTon(){
        System.out.println("init here");
    }

    public static EnumSingleTon getInstance(){
        return myEnum.INSTANCE.getInstance();
    }


    private static enum myEnum{
        INSTANCE;

        private EnumSingleTon singleTon;

        private myEnum(){
            singleTon = new EnumSingleTon();
        }

        private EnumSingleTon getInstance(){
            return singleTon;
        }

    }

    public static void main(String[] args) {
        EnumSingleTon singleTon = EnumSingleTon.getInstance();
    }


}
