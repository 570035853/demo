package multiThread.multiThreadTask;

/**
 * Created by zoujialei on 17/11/2.
 */
public class ThreadTest {


    public static void main(String[] args) {
        /*
        //runnable实现
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();
        new Thread(myRunnable).start();
        new Thread(myRunnable).start();
        */


        // thread实现
        MyThread myThread5 = new MyThread(0);
        MyThread myThread1 = new MyThread(1);
        MyThread myThread2 = new MyThread(2);
        MyThread myThread3 = new MyThread(3);
        MyThread myThread4 = new MyThread(4);

        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread5.start();



        /*
        MyThread myThread = new MyThread(0);
        myThread.start();
        myThread.start();

        Thread thread = Thread.currentThread();
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            //do noting
        }

        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();
        */
    }


}
