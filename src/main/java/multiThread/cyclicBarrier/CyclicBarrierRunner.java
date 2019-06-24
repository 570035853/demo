package multiThread.cyclicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Created by jialei.zou on 2019/6/24 .
 * ref:
 * https://blog.csdn.net/u014574317/article/details/78762320
 * 对比看CountDownLatchRunner
 *
 */
public class CyclicBarrierRunner {

    private static final int N = 5;

    public static final void main(String[] args) {
        testCyclicBarrier();
    }

    private static void testCyclicBarrier() {
        CyclicBarrier barrierPrepare = new CyclicBarrier(N, new Runnable() {

            @Override
            public void run() {
                System.out.println("所有运动员准备完毕,开始比赛");
            }
        });
        CyclicBarrier barrierOver = new CyclicBarrier(N, new Runnable() {

            @Override
            public void run() {
                System.out.println("所有运动员比赛都完成了,结束比赛");
            }
        });

        for (int i = 0; i < N; i++) {
            new Thread(new Player(i, barrierPrepare, barrierOver)).start();
        }
    }

    static class Player implements Runnable {

        private CyclicBarrier barrierPrepared;
        private CyclicBarrier barrierOver;
        private int id;
        private static Random sRandom = new Random();

        public Player(int id, CyclicBarrier barrierPrepared, CyclicBarrier barrierOver) {
            this.barrierPrepared = barrierPrepared;
            this.barrierOver = barrierOver;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(sRandom.nextInt(3));
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("运动员" + id + "准备比赛");
            try {
                barrierPrepared.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("远动员" + id + "开始比赛" + System.currentTimeMillis());
            int duration = sRandom.nextInt(5);
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("运动员" + id + "完成比赛，比赛时长：" + duration);
            try {
                barrierOver.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }

    }


}
