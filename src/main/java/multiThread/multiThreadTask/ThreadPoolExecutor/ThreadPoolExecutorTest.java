package multiThread.multiThreadTask.ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zoujialei on 2018/6/18.
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                10,
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i<20; i++){
            threadPoolExecutor.execute(new Task(i));
        }

        System.out.println("end here");
    }




}
