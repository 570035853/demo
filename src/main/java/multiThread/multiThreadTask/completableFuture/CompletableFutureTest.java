package multiThread.multiThreadTask.completableFuture;

import multiThread.ThreadPool.MyRejected;

import java.util.concurrent.*;

/**
 * @author zoujialei02
 * @date 2021/11/3
 * 可见 (最终依赖系统提供的方法，阻塞相应的时间，看到系统层就先不用看了)
 * {@link multiThread.LockSupport.LockSupportDemo}
 *
 * 1.相对于ListenableFuture来说，优势就是一点：可组合，可编排，这一点的美团技术文章有说明：
 * https://tech.meituan.com/2022/05/12/principles-and-practices-of-completablefuture.html
 * 简单总结
 * 1）数据结构：每个CF都有一个result，用户保存执行结果，有一个stack，用户保存依赖该CF的其他0个或多个CF。
 * 2）观察者模式通知：对于异步任务，当前CF执行完之后，如何通知后续需要执行的CF：每个和当前线程相关的CF，都在关联的时候写入到了当前线程的栈中，当前线程执行完后，就通知所有栈中CF；
 * 3）对于文章提及的多元依赖，为啥多个被依赖是AndTree，而不是链表或数据：主要用下二元依赖的数据结构，就不用在单独引入其他数据结构了，例如链表、数组等还要在写一套时间。
 * 二元依赖的结构，如果是两个依赖都ready才执行Action，两个左右节点的根节点才会ready，这样一层一层向上运算，遍完成了整个树中所有节点的遍历。
 *
 * 2.本文章基本把如何使用将清楚了：https://juejin.cn/post/7100402930083168292
 * 简单总结下：
 * 1）runAsync和supplyAsync分别对应Runnable和Supplier接口，Run没有返回值，supply有返回值
 * 2）non-sync和sync区别：sync方法要么使用系统自带的commonPool执行，要么使用使用调用者传入的线程池执行；
 *      non-sync的thenApply由谁执行：要看注册时候，被依赖的操作是否已经执行完成，如果执行完成，则用当前线程执行thenApply，否则用依赖线程执行
 * 3）每个动作基本都对应三个方法，一个同步执行，两个异步执行（异步执行有一个由commonPool线程池执行，一个由用户自定义线程池执行）
 * 4）方法有顺序执行（支持结果转换）、两个任务执行（一个先执行、同时都执行后才执行Action，两个中一个完成执行Action）、多任务执行（全部执行后执行Action，一个完成后执行Action）
 * 5）没觉得thenApply和thenCompose有啥区别？？？后续在看
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
                CompletableFuture.supplyAsync(()->CaculateWeight.getWomenWeight(2), pool);

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
