package interview.AQS;

/**
 * Created by jialei.zou on 2019/6/8 .
 */
public class InitTest {

    private int value = 10;
    ThreadLocal threadLocal;
    SelfObject selfObject;

    public InitTest(){
        System.out.println(" change value start");
        this.value = 30;
        System.out.println(" change value end, value:"+value);

        threadLocal = new ThreadLocal(){
            @Override
            protected Object initialValue() {
                System.out.println("threadLocal init ");
                return null;
            }
        };
        selfObject = new SelfObject();
        System.out.println("init test");
    }

    public static void main(String[] args) {
        InitTest initTest = new InitTest();
    }
}
