package multiThread.cyclicBarrier;

import common.SleepUtils;

import java.util.concurrent.*;

/**
 * Created by jialei.zou on 2019/6/24 .
 * ref:
 * https://www.cnblogs.com/dolphin0520/p/3920397.html
 *
 * 都什么：1组线程的协同动作，当条件合适的时候，便一起开始，万箭齐发，
 *
 * 和countdownlatch的区别
 * 不像countdownlatch，设计A线程及另外一个线程组，其为两个主体的协调，
 * 而CyclicBarrier是一个主体（一组线程的协同动作）
 *
 */
public class CyclicBarrierDemo {


    public static void main(String[] args) {
        int num =5;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(num,
                num,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(num),
                new ThreadPoolExecutor.AbortPolicy());


        /**
         * 如果使用如下方式，则等待所有线程组内的线程都达到指定状态的时候，先从整个组里面选一个线程，然后执行barrierAction，
         * 等执行完barrierAction之后，在继续执行await后面的任务
         */
        Runnable barrierAction = new Runnable() {
            @Override
            public void run() {
                System.out.println("barrierAction start, thread name:"+Thread.currentThread().getName());
                SleepUtils.seconds(5);
                System.out.println("barrierAction end, thread name:"+Thread.currentThread().getName());
            }
        };

        CyclicBarrier cyclicBarrier = new CyclicBarrier(num, barrierAction);

        //
        for (int i = 0 ; i<num; i++){
            SleepUtils.seconds(1);
            executor.execute(new MyThread(i, cyclicBarrier));
        }

        for (int i = 0 ; i<num; i++){
            SleepUtils.seconds(1);
            executor.execute(new MyThread(i, cyclicBarrier));
        }

        SleepUtils.seconds(3);
        executor.shutdown();
        System.out.println("end");
    }


    static class MyThread implements Runnable{

        int id;
        private CyclicBarrier cyclicBarrier;

        MyThread(int id, CyclicBarrier cyclicBarrier){
            this.id = id;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run(){
            try {
                cyclicBarrier.await();
            }catch (InterruptedException e ){
                e.printStackTrace();
            }catch(BrokenBarrierException e){
                e.printStackTrace();
            }

            System.out.println("MyThread start, id:"+id+" thread name:" + Thread.currentThread().getName());
            SleepUtils.seconds(1);
            System.out.println("MyThread end, id:"+id);

        }
    }
}
