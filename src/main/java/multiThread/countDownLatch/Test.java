package multiThread.countDownLatch;

import com.alibaba.fastjson.JSON;
import common.SleepUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by jialei.zou on 2018/12/31 .
 * 使用countDownLatch来完成如下并发控制
 * 主线程分发打印1-30的任务（分为三次）给到10个线程，每个线程打印一个，需要做到如下的顺序性
 * 1. 主线程发任务的时候，执行线程等待；
 * 2. 执行线程完成打印工作后，主线程发下一轮的工作
 *
 */
public class Test {

    private static CountDownLatch countDownLatch;

    private static void doWork(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10,
                20,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(100));
        int total = 30;
        int from = 0;
        int step = 10;
        while (true){
            if(from>=total){
                System.out.println("from>total");
                break;
            }
            countDownLatch = new CountDownLatch(10);

            List<Integer> list = new ArrayList<>();

            //mock get data from db
            for (int i = 0; i<step; i++){
                list.add(from+i);
            }
            from += step;

            System.out.println("distribute tasks, list:"+ JSON.toJSONString(list));
            for (int i = 0; i<step; i++){
                threadPoolExecutor.execute(new MyThread(i, list));
            }

            SleepUtils.seconds(1);
            try {
                countDownLatch.await();
                System.out.println("distribute doneSignal wait");
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
        System.out.println("end");
        threadPoolExecutor.shutdown();
    }


    public static void main(String[] args) {
        doWork();
    }

    private static class MyThread implements Runnable{
        private int id;
        private List<Integer> list;

        public MyThread(int id, List<Integer> list){
            this.id = id;
            this.list = list;
        }

        @Override
        public void run(){
            System.out.println("thread id:"+id+"startSignal wait");
            SleepUtils.seconds(1);
            for (Integer item: list){
                if(item.intValue() %10 == id){
                    System.out.println("thread id:"+id+", item:"+item.intValue());
                }
            }
            countDownLatch.countDown();
            System.out.println("thread id:"+id+" doneSignal countDown");
        }
    }


}
