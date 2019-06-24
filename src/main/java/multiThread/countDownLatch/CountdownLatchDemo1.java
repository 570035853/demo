package multiThread.countDownLatch;

import common.SleepUtils;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jialei.zou on 2019/6/24 .
 * 一般就是用于控制，其他几个线程执行完成后，指定的线程再执行
 */
public class CountdownLatchDemo1 {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("thread1 start");
                    countDownLatch.await();
                    System.out.println("thread1 end");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 start");
                SleepUtils.seconds(2);
                countDownLatch.countDown();
                System.out.println("thread2 end");

            }
        });


        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread3 start");
                SleepUtils.seconds(2);
                countDownLatch.countDown();
                System.out.println("thread3 end");



            }
        });

        thread1.start();
        thread2.start();
        thread3.start();


    }
}
