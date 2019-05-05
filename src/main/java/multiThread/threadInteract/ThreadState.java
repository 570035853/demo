package multiThread.threadInteract;

/**
 * Created by jialei.zou on 2019/4/30 .
 * 总结：
 * 1. wait和notify必须当前线程已经拿到锁才可以使用
 * 2. 带有等待时间参数的wait，如果在等待时间内得到了通知，则不会等待，继续执行
 */
public class ThreadState {

    public static void main(String[] args) {
        final Object object = new Object();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    try {
                        System.out.println("thread1 run start");
                        object.wait(10000);
                        System.out.println("thread1 run end");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    System.out.println("thread2 run start");
                    object.notify();
                    System.out.println("thread2 run end");
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
