package multiThread.multiThreadTask.executeByGivenOrder.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jialei.zou on 2019/6/10 .
 */
public class Test {

    public static void main(String[] args) {
        CountDownLatch t1 = new CountDownLatch(1);
        CountDownLatch t23 = new CountDownLatch(2);
        Thread thread1 = new Thread(new T1(t1));
        Thread thread2 = new Thread(new T2(t1, t23));
        Thread thread3 = new Thread(new T2(t1, t23));
        Thread thread4 = new Thread(new T4(t23));

        thread3.start();
        thread4.start();
        thread1.start();
        thread2.start();


    }
}
