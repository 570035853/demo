package multiThread.threadInteract;

import common.SleepUtils;

public class WaitAndNotify {

    public static void main(String[] args) {
        final Object object = new Object();
        Thread t1 = new Thread() {
            public void run() {
                synchronized (object) {
                    System.out.println("T1 start!");
                    try {
                        object.wait();
                        SleepUtils.seconds(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("T1 end!");
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                synchronized (object) {
                    System.out.println("T2 start!");
                    object.notifyAll();  //通知所有的，被通知的线程一个挨一个的获取锁，并分别执行后续逻辑
//                    object.notify(); //随机通知一个
                    System.out.println("T2 end!");
                }
            }
        };

        Thread t3 = new Thread() {
            public void run() {
                synchronized (object) {
                    System.out.println("T3 start!");
                    try {
                        object.wait();
                        SleepUtils.seconds(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("T3 end!");
                }
            }
        };


        Thread t4 = new Thread() {
            public void run() {
                synchronized (object) {
                    System.out.println("T4 start!");
                    try {
                        object.wait();
                        SleepUtils.seconds(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("T4 end!");
                }
            }
        };


        t1.start();
//        t3.start();
//        t4.start();

        SleepUtils.seconds(5);

//        t2.start();
        t1.interrupt();
        System.out.println("main thread");
        SleepUtils.seconds(2);
        System.out.println("main thread wakeup");



    }
}
