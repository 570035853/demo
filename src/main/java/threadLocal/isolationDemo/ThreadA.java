package threadLocal.isolationDemo;

/**
 * Created by jialei.zou on 2018/7/27 .
 */
public class ThreadA extends Thread{
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++){
                Tool.t1.set("ThreadA+"+(i+1));
                System.out.println("ThreadA获取的值为 "+ Tool.t1.get());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
