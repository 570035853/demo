package multiThread.countDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by jialei.zou on 2019/6/24 .
 * ref:
 * https://blog.csdn.net/u014574317/article/details/78762320
 * 比赛开始和比赛结束的控制，对比看CyclicBarrierRunner
 *
 */
public class CountDownLatchRunner {

    private static final int N = 5;

    public static void main(String[] args) {
        testCountDownLatch();
    }

    private static void testCountDownLatch() {
        CountDownLatch latchStart = new CountDownLatch(N);
        CountDownLatch latchOver = new CountDownLatch(N);
        CountDownLatch startSignal = new CountDownLatch(1);

        for (int i = 0; i < N; i++) {
            new Thread(new Player(i, latchStart, latchOver, startSignal)).start();
        }
        System.out.println("等待运动员准备好");
        try {
            latchStart.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开始比赛");
        startSignal.countDown();
        try {
            latchOver.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有运动员都完成了比赛，比赛结束");
    }

    static class Player implements Runnable {
        private CountDownLatch latchStart;
        private CountDownLatch latchOver;
        private CountDownLatch startSignal;

        private int id;
        private static Random sRandom = new Random();

        public Player(int id, CountDownLatch latchStart, CountDownLatch lacthOver, CountDownLatch startSignal) {
            this.id = id;
            this.latchStart = latchStart;
            this.latchOver = lacthOver;
            this.startSignal = startSignal;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(sRandom.nextInt(2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Player" + id + "准备好" + System.currentTimeMillis());
            this.latchStart.countDown();
            try {
                this.startSignal.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Player" + id + "开始跑" + System.currentTimeMillis());
            long duration = sRandom.nextInt(5);
            try {
                TimeUnit.SECONDS.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Player" + id + "完成比赛, 耗时：" + duration);
            this.latchOver.countDown();
        }
    }

}
