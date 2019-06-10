package multiThread.multiThreadTask.executeByGivenOrder.countDownLatch;

import common.SleepUtils;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jialei.zou on 2019/6/10 .
 */
public class T4 implements Runnable {

    private CountDownLatch wait;

    public T4(CountDownLatch wait){
        this.wait = wait;
    }

    @Override
    public void run(){
        try {
            wait.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("T4 started and do something");
        SleepUtils.seconds(1);
    }
}
