package classLoader;

class SingleTonTest {
//    private static SingleTonTest singleTon = new SingleTonTest();
    //从上到下依次赋值

    public static int count1;
    public final static int count2 = 0;

    private static SingleTonTest singleTon = new SingleTonTest();
//    此位置打印 1 1

    private SingleTonTest() {
        count1++;
//        count2++;
        System.out.println("SingleTonTest init");
    }

    public static SingleTonTest getInstance() {
        return singleTon;
    }
}

public class SingleTon {
    public static void main(String[] args) {
//        SingleTonTest singleTon = SingleTonTest.getInstance();
//        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + SingleTonTest.count2);
    }
}