package multiThread.threadState.join;

import java.util.Date;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by jialei.zou on 2018/9/3 .
 */
public class Join2 implements Runnable {

    private String name;
    private int sleepMill;

    public Join2(String name, int sleepMill) {
        this.name = name;
        this.sleepMill = sleepMill;
    }

    public void run() {
        System.out.printf("%s begins: %s\n", name, new Date());
        try {
            TimeUnit.SECONDS.sleep(sleepMill);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s has finished: %s\n", name, new Date());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Join2("One", 4));
        Thread thread2 = new Thread(new Join2("Two", 5));
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Main thread is finished");
    }

}
