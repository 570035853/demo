package multiThread.multiThreadTask.completableFuture;

import multiThread.ThreadPool.MyRejected;

import java.util.concurrent.*;

/**
 * @author zoujialei02
 * @date 2021/11/3
 * 可见 (最终依赖系统提供的方法，阻塞相应的时间，看到系统层就先不用看了)
 * {@link multiThread.LockSupport.LockSupportDemo}
 */
public class CompletableFutureTest {

    private static ThreadPoolExecutor pool = new ThreadPoolExecutor(
            5,              //coreSize
            10,              //MaxSize
            60,             //60
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(3)  //指定一种队列 （有界队列）
            //new LinkedBlockingQueue<Runnable>()
            , new MyRejected().new Handle()
            //, new DiscardOldestPolicy()
    );


    public static void main(String[] args) {
        //可以理解为一次RPC 获取男性体重
        CompletableFuture<Integer> manWeight =
                CompletableFuture.supplyAsync(()->CaculateWeight.getManWeight(), pool);

        //这个地方因为时间段虽然get不到结果，但是不影响程序整体结果的获取
        try {
            System.out.println("get manWeight:"+manWeight.get(1000, TimeUnit.MILLISECONDS));
        }catch (Exception e){
            e.printStackTrace();
        }

        //可以理解为一次RPC 获取女性体重
        CompletableFuture<Integer> womenWeight =
                CompletableFuture.supplyAsync(()->CaculateWeight.getWomenWeight(), pool);

        //可以理解为一次RPC 获取总计体重
        CompletableFuture<Integer> totalWeight = manWeight.thenCombineAsync(womenWeight,
                (a1, a2)->CaculateWeight.getTotalWeight(a1, a2), pool)
                .exceptionally(e-> {System.out.println(e); return 0;});

        try {
            System.out.println("totalWeight:"+totalWeight.get());
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("end");


        pool.shutdown();
    }

}
