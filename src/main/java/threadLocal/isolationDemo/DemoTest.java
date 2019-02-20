package threadLocal.isolationDemo;

/**
 * Created by jialei.zou on 2018/7/27 .
 */
public class DemoTest {
    public static void main(String[] args){
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        a.start();
        b.start();
        try {
            for (int i = 0; i < 10; i++){
                Tool.t1.set("Main+"+(i+1));
                System.out.println("Main获取的值为 "+ Tool.t1.get());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
