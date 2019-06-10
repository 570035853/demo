package multiThread.multiThreadTask.executeByGivenOrder.countDownLatch;

import common.SleepUtils;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jialei.zou on 2019/6/10 .
 */
public class T2 implements Runnable {

    private CountDownLatch wait;
    private CountDownLatch done;

    public T2(CountDownLatch wait, CountDownLatch done){
        this.wait = wait;
        this.done= done;

    }

    @Override
    public void run(){
        try {
            wait.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("T2 started and do something");
        SleepUtils.seconds(2);
        done.countDown();

    }
}
