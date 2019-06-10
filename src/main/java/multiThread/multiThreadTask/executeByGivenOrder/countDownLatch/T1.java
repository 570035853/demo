package multiThread.multiThreadTask.executeByGivenOrder.countDownLatch;

import common.SleepUtils;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jialei.zou on 2019/6/10 .
 */
public class T1 implements Runnable {
    private CountDownLatch done;

    public T1(CountDownLatch done){
        this.done = done;
    }

    @Override
    public void run(){
        System.out.println("T1 Start and do something");
        SleepUtils.seconds(1);
        done.countDown();
    }
}
