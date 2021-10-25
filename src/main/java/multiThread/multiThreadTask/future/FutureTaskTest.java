package multiThread.multiThreadTask.future;

import java.util.concurrent.*;

/**
 * @author zoujialei02
 * @date 2021/6/29
 */
public class FutureTaskTest {


    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                10,
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5),
                new ThreadPoolExecutor.AbortPolicy());

        Future<SpuResult> future = threadPoolExecutor.submit(new CallableTask(567L));
        try {
            System.out.println("time1: "+System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println("time2: "+System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("time3: "+System.currentTimeMillis());
        SpuResult spuResult = null;
        try {
            spuResult = future.get();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("time4: "+System.currentTimeMillis());
        System.out.println(spuResult);
        threadPoolExecutor.shutdown();
//        System.out.println("123");
    }
}
