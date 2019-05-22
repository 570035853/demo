package multiThread.LockSupport;

import common.SleepUtils;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by jialei.zou on 2019/5/20 .
 */
public class LockSupportDemo {

    public static void main(String[] args) {
        Thread parkThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("park begin");

                //等待获取许可
                LockSupport.park();
                //输出thread over.true
                System.out.println("thread over." + Thread.currentThread().isInterrupted());

            }
        });
        parkThread.start();

        SleepUtils.seconds(2);
        // 中断线程后，后续的打印thread over立即执行：这就是所说的虽然不抛出中断异常，但是有中断，也会立即进行中断并继续
        parkThread.interrupt();

        SleepUtils.seconds(2);

        System.out.println("main over");



    }

}
