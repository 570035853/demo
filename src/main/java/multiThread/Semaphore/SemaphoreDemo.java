package multiThread.Semaphore;

import java.util.concurrent.*;

/**
 * Created by jialei.zou on 2019/4/30 .
 */
public class SemaphoreDemo {


    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
                10, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10), new ThreadPoolExecutor.AbortPolicy());

        final Semaphore semaphore = new Semaphore(5);
        for (int index = 0; index < 21; index++) {
            final int NO = index;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("Accessing:" + NO);
                        Thread.sleep((long) (Math.random() * 10000));
                        semaphore.release();
                        System.out.println("------------------" + semaphore.availablePermits());
                    } catch (InterruptedException e) {
                        e.printStackTrace();                }
                }
            };

            executor.execute(runnable);
        }

        executor.shutdown();
    }
}
