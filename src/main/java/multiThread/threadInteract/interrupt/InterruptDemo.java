package multiThread.threadInteract.interrupt;

import common.SleepUtils;

/**
 * Created by jialei.zou on 2019/5/2 .
 * ref: 《Java并发编程的艺术》 第4章 p92
 * 总结：
 * busyRunner这种，即便将isInterrupt设置了，也不会被中断
 *



 对线程进行Interrupt，实际是改变的线程的标志位来实现的，如果该线程能够响应中断，可以分为如下两种情况
 1. 如果正在运行的线程所待执行的动作能够响应中断，例如正在wait、sleep等，发生中断后，系统会抛出一个中断异常，运行线程捕获后进行相关处理即可
 2. 使得在使用isInterrupted接口来进行判断的时候，如果发生了中断，则进行响应的处理

 如果被中断的线程不是上述两种情况，则继续该怎么执行就怎么执行

 线程被中断后，会释放该线程下的相关锁


 *
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
                /**
                 * 如下方法内部会响应中断，抓住异常的同时，其内部对异常的处理只是打印了异常
                 * 还有别的处理方式，例如seconds方法定义返回为boolean类型，如果此地方定义有异常的时候
                 * 返回boolean为true，接到true之后，则进行break，则该线程任务就结束了
                 *
                 */
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
