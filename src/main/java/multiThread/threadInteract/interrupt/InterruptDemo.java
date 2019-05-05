package multiThread.threadInteract.interrupt;

import common.SleepUtils;

/**
 * Created by jialei.zou on 2019/5/2 .
 * ref: 《Java并发编程的艺术》 第4章 p92
 * 总结：
 * busyRunner这种，即便将isInterrupt设置了，也不会被中断
 */
public class InterruptDemo {


    static class BusyRunner implements Runnable{
        @Override
        public void run(){
            long from = System.currentTimeMillis();
            while (true){
                //keep running
                long now = System.currentTimeMillis();
                if(now - from>2000){
                    System.out.println("BusyRunner run 2 seconds");
                    from = now;
                }
            }
        }
    }


    static class SleepRunner implements Runnable{
        @Override
        public void run(){
            while (true){
                System.out.println("SleepRunner sleep for 10 seconds");
                SleepUtils.seconds(10);
            }
        }
    }


    public static void main(String[] args) {
        Thread busyThread = new Thread(new BusyRunner(), "busyThread");
        Thread sleepThread = new Thread(new SleepRunner(), "sleepRunner");
        busyThread.start();
        sleepThread.start();
        SleepUtils.seconds(5);
        busyThread.interrupt();
        sleepThread.interrupt();
        System.out.println(busyThread.isInterrupted());

        System.out.println(sleepThread.isInterrupted());

        try {
            busyThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
