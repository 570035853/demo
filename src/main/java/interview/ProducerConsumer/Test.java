package interview.ProducerConsumer;

import java.util.concurrent.*;

/**
 * ref: https://blog.csdn.net/qq_27603235/article/details/73744768
 */
public class Test {

    public static void main(String[] args) {
        BlockingDeque<Data> queue = new LinkedBlockingDeque<Data>(10);

        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Producer producer4 = new Producer(queue);
        Producer producer5 = new Producer(queue);


        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);
        Consumer consumer4 = new Consumer(queue);
        Consumer consumer5 = new Consumer(queue);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,
                20,
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5),
                new ThreadPoolExecutor.AbortPolicy());
        executor.execute(producer1);
        executor.execute(producer1);
        executor.execute(producer1);
        executor.execute(producer1);
        executor.execute(producer1);

        executor.execute(consumer1);
        executor.execute(consumer1);
        executor.execute(consumer1);
        executor.execute(consumer1);
        executor.execute(consumer1);


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end here");
    }
}
